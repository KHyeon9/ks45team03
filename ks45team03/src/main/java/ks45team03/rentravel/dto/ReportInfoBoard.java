package ks45team03.rentravel.dto;

public class ReportInfoBoard {

	private String reportInfoBoardCode;
	private String reportTypeCode;
	private String InfoBoardCode;
	private String reportStateCode;
	private String reportingUserId;
	private String reportedUserId;
	private String reportInfoBoardContent;
	private String reportInfoBoardDatetime;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportInfoBoard [reportInfoBoardCode=");
		builder.append(reportInfoBoardCode);
		builder.append(", reportTypeCode=");
		builder.append(reportTypeCode);
		builder.append(", InfoBoardCode=");
		builder.append(InfoBoardCode);
		builder.append(", reportStateCode=");
		builder.append(reportStateCode);
		builder.append(", reportingUserId=");
		builder.append(reportingUserId);
		builder.append(", reportedUserId=");
		builder.append(reportedUserId);
		builder.append(", reportInfoBoardContent=");
		builder.append(reportInfoBoardContent);
		builder.append(", reportDatetime=");
		builder.append(reportInfoBoardDatetime);
		builder.append("]");
		return builder.toString();
	}
	public String getReportInfoBoardCode() {
		return reportInfoBoardCode;
	}
	public void setReportInfoBoardCode(String reportInfoBoardCode) {
		this.reportInfoBoardCode = reportInfoBoardCode;
	}
	public String getReportTypeCode() {
		return reportTypeCode;
	}
	public void setReportTypeCode(String reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}
	public String getInfoBoardCode() {
		return InfoBoardCode;
	}
	public void setInfoBoardCode(String infoBoardCode) {
		InfoBoardCode = infoBoardCode;
	}
	public String getReportStateCode() {
		return reportStateCode;
	}
	public void setReportStateCode(String reportStateCode) {
		this.reportStateCode = reportStateCode;
	}
	public String getReportingUserId() {
		return reportingUserId;
	}
	public void setReportingUserId(String reportingUserId) {
		this.reportingUserId = reportingUserId;
	}
	public String getReportedUserId() {
		return reportedUserId;
	}
	public void setReportedUserId(String reportedUserId) {
		this.reportedUserId = reportedUserId;
	}
	public String getReportInfoBoardContent() {
		return reportInfoBoardContent;
	}
	public void setReportInfoBoardContent(String reportInfoBoardContent) {
		this.reportInfoBoardContent = reportInfoBoardContent;
	}
	public String getReportInfoBoardDatetime() {
		return reportInfoBoardDatetime;
	}
	public void setReportInfoBoardDatetime(String reportInfoBoardDatetime) {
		this.reportInfoBoardDatetime = reportInfoBoardDatetime;
	}
	
}
