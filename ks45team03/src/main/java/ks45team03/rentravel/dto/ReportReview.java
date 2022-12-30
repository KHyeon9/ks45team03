package ks45team03.rentravel.dto;

public class ReportReview {

	private String reportReviewCode;
	private String reportTypeCode;
	private String reviewCode;
	private String reportStateCode;
	private String reportingUserId;
	private String reportedUserId;
	private String reportReviewContent;
	private String reportReviewDatetime;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportReview [reportReviewCode=");
		builder.append(reportReviewCode);
		builder.append(", reportTypeCode=");
		builder.append(reportTypeCode);
		builder.append(", reviewCode=");
		builder.append(reviewCode);
		builder.append(", reportStateCode=");
		builder.append(reportStateCode);
		builder.append(", reportingUserId=");
		builder.append(reportingUserId);
		builder.append(", reportedUserId=");
		builder.append(reportedUserId);
		builder.append(", reportReviewContent=");
		builder.append(reportReviewContent);
		builder.append(", reportReviewDatetime=");
		builder.append(reportReviewDatetime);
		builder.append("]");
		return builder.toString();
	}
	public String getReportReviewCode() {
		return reportReviewCode;
	}
	public void setReportReviewCode(String reportReviewCode) {
		this.reportReviewCode = reportReviewCode;
	}
	public String getReportTypeCode() {
		return reportTypeCode;
	}
	public void setReportTypeCode(String reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}
	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
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
	public String getReportReviewContent() {
		return reportReviewContent;
	}
	public void setReportReviewContent(String reportReviewContent) {
		this.reportReviewContent = reportReviewContent;
	}
	public String getReportReviewDatetime() {
		return reportReviewDatetime;
	}
	public void setReportReviewDatetime(String reportReviewDatetime) {
		this.reportReviewDatetime = reportReviewDatetime;
	}
}
