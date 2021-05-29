package com.mooney.devops.testing.utility.bundlechecktool.web.dto;

public class FileTransferDto {
	
	private String fileName;
	
	private String extension;
	
	private String mimeType;
	
	private String base64;
	
	

	public FileTransferDto(String fileName, String extension, String mimeType, String base64) {
		super();
		this.fileName = fileName;
		this.extension = extension;
		this.mimeType = mimeType;
		this.base64 = base64;
	}
	

	public String getMimeType() {
		return mimeType;
	}

	public String getFileName() {
		return fileName;
	}

	public String getExtension() {
		return extension;
	}


	public String getBase64() {
		return base64;
	}

	
	

}
