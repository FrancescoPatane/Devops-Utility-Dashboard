package com.mooney.devops.testing.utility.diagnostictool.ssh;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mooney.devops.testing.utility.common.exceptions.RemoteConnectionException;
import com.mooney.devops.testing.utility.diagnostictool.web.DiagnosticRestServiceController;

@Component
public class RemoteSshExecutor {
	
	private static final Logger logger = LoggerFactory.getLogger(RemoteSshExecutor.class);


	private static final int REMOTE_PORT = 22;
	private static final int SESSION_TIMEOUT = 10000;
	private static final int CHANNEL_TIMEOUT = 5000;

	@Value("${remote.username}")
	private String username;

	@Value("${remote.password}")
	private String password;

	@Value("${remote.remoteshellscript}")
	private String remoteshellscript;



	public String execRemoteSh (String targetHost) {
		logger.info("Remote call towards {}", targetHost);
		Session jschSession = null;

		try {

			JSch jsch = new JSch();
			jschSession = jsch.getSession(username, targetHost, REMOTE_PORT);
			jschSession.setConfig("StrictHostKeyChecking", "no");
			jschSession.setPassword(password);
			jschSession.connect(SESSION_TIMEOUT);

			ChannelExec channelExec = (ChannelExec) jschSession.openChannel("exec");

			// run a shell script
			channelExec.setCommand("sh " + remoteshellscript );

			// display errors to System.err
			channelExec.setErrStream(System.err);


			channelExec.connect(CHANNEL_TIMEOUT);

			String response = this.readResponse(channelExec);

			channelExec.disconnect();

			return response;

		} catch (JSchException | IOException e) {

			throw new RemoteConnectionException("Jsch Error connecting to " + targetHost + ",  " + remoteshellscript, e);

		} finally {
			if (jschSession != null) {
				jschSession.disconnect();
			}
		}

	}

	private String readResponse(ChannelExec channelExec) throws IOException {
		// read the result from remote server
		StringBuilder sb = new StringBuilder(1024);
		InputStream in = channelExec.getInputStream();
		byte[] tmp = new byte[1024];
		while (true) {
			while (in.available() > 0) {
				int i = in.read(tmp, 0, 1024);
				if (i < 0) break;
				String toAppend = new String(tmp, 0, i);
				logger.info(toAppend);
				sb.append(toAppend);
			}
			if (channelExec.isClosed()) {
				if (in.available() > 0) continue;
				logger.info("exit-status: {}", channelExec.getExitStatus());
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception ee) {
			}
		}
		return sb.toString();
	}

}
