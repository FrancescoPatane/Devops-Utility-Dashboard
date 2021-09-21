package com.mooney.devops.testing.utility.diagnostictool.ssh;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

@Component
public class RemoteSshExecutor {
	
//    private static final String REMOTE_HOST = "t1npspas01.sisalpay5group.local";
	private static final String REMOTE_HOST = "s1npspas01.sisalpay5group.local";
    
//    private static final String USERNAME = "patane";
//    private static final String PASSWORD = "Sshfp-92#1";
  private static final String USERNAME = "tramontana";
  private static final String PASSWORD = "2021Mny_08";
//  private static final String remoteShellScript = "/home/patane/monitoring/monitoring.sh";
  private static final String REMOTESHELLSCRIPT = "/home/tramontana/monitoring/monitoring.sh";

    private static final int REMOTE_PORT = 22;
    private static final int SESSION_TIMEOUT = 10000;
    private static final int CHANNEL_TIMEOUT = 5000;

    public String execRemoteSh () {

//        String remoteShellScript = "/home/patane/monitoring/monitoring.sh";

        Session jschSession = null;

        try {

            JSch jsch = new JSch();
//            jsch.setKnownHosts("/home/mkyong/.ssh/known_hosts");
            jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);

            // not recommend, uses jsch.setKnownHosts
            jschSession.setConfig("StrictHostKeyChecking", "no");
            
            

            // authenticate using password
            jschSession.setPassword(PASSWORD);

            // 10 seconds timeout session
            jschSession.connect(SESSION_TIMEOUT);

            ChannelExec channelExec = (ChannelExec) jschSession.openChannel("exec");

            // run a shell script
            channelExec.setCommand("sh " + REMOTESHELLSCRIPT );

            // display errors to System.err
            channelExec.setErrStream(System.err);

            InputStream in = channelExec.getInputStream();

            // 5 seconds timeout channel
            channelExec.connect(CHANNEL_TIMEOUT);

            // read the result from remote server
            byte[] tmp = new byte[1024];
            StringBuilder sb = new StringBuilder(1024);
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                    sb.append(new String(tmp, 0, i));
                }
                if (channelExec.isClosed()) {
                    if (in.available() > 0) continue;
                    System.out.println("exit-status: "
                         + channelExec.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            
            channelExec.disconnect();
            
            return sb.toString();

        } catch (JSchException | IOException e) {

            throw new RuntimeException("Jsch Error", e);

        } finally {
            if (jschSession != null) {
                jschSession.disconnect();
            }
        }

    }

}
