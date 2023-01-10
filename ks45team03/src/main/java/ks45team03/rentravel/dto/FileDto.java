package ks45team03.rentravel.dto;

public class FileDto {

	private String fileCode;
	private String fileOriginalName;
	private String fileNewName;
	private String filePath;
	private Long fileSize;
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getFileOriginalName() {
		return fileOriginalName;
	}
	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}
	public String getFileNewName() {
		return fileNewName;
	}
	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	public Long getFileSize() {
		return fileSize;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileDto [fileCode=");
		builder.append(fileCode);
		builder.append(", fileOriginalName=");
		builder.append(fileOriginalName);
		builder.append(", fileNewName=");
		builder.append(fileNewName);
		builder.append(", filePath=");
		builder.append(filePath);
		builder.append(", fileSize=");
		builder.append(fileSize);
		builder.append("]");
		return builder.toString();
	}
	
}
