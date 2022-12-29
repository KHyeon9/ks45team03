package ks45team03.rentravel.dto;

public class ReportComment {

	private String reportCommentCode;
	private String reportTypeCode;
	private String infoBoardCommentCode;
	private String reportStateCode;
	private String reportingUserId;
	private String reportedUserId;
	private String reportCommentContent;
	private String reportCommentDatetime;
	public String getReportCommentCode() {
		return reportCommentCode;
	}
	public void setReportCommentCode(String reportCommentCode) {
		this.reportCommentCode = reportCommentCode;
	}
	public String getReportTypeCode() {
		return reportTypeCode;
	}
	public void setReportTypeCode(String reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}
	public String getInfoBoardCommentCode() {
		return infoBoardCommentCode;
	}
	public void setInfoBoardCommentCode(String infoBoardCommentCode) {
		this.infoBoardCommentCode = infoBoardCommentCode;
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
	public String getReportCommentContent() {
		return reportCommentContent;
	}
	public void setReportCommentContent(String reportCommentContent) {
		this.reportCommentContent = reportCommentContent;
	}
	public String getReportCommentDatetime() {
		return reportCommentDatetime;
	}
	public void setReportCommentDatetime(String reportCommentDatetime) {
		this.reportCommentDatetime = reportCommentDatetime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportComment [reportCommentCode=");
		builder.append(reportCommentCode);
		builder.append(", reportTypeCode=");
		builder.append(reportTypeCode);
		builder.append(", infoBoardCommentCode=");
		builder.append(infoBoardCommentCode);
		builder.append(", reportStateCode=");
		builder.append(reportStateCode);
		builder.append(", reportingUserId=");
		builder.append(reportingUserId);
		builder.append(", reportedUserId=");
		builder.append(reportedUserId);
		builder.append(", reportCommentContent=");
		builder.append(reportCommentContent);
		builder.append(", reportCommentDatetime=");
		builder.append(reportCommentDatetime);
		builder.append("]");
		return builder.toString();
	}
	
}
