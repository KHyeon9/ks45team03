package ks45team03.rentravel.dto;

public class ReportGoods {

	private String reportGoodsCode;
	private String reportTypeCode;
	private String goodsCode;
	private String reportStateCode;
	private String reportingUserId;
	private String reportedUserId;
	private String reportGoodsContent;
	private String reportGoodsDateTime;
	
	ReportState reportState;
	ReportType reportType;
	
	public ReportState getReportState() {
		return reportState;
	}
	public void setReportState(ReportState reportState) {
		this.reportState = reportState;
	}
	public ReportType getReportType() {
		return reportType;
	}
	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}
	public String getReportGoodsCode() {
		return reportGoodsCode;
	}
	public void setReportGoodsCode(String reportGoodsCode) {
		this.reportGoodsCode = reportGoodsCode;
	}
	public String getReportTypeCode() {
		return reportTypeCode;
	}
	public void setReportTypeCode(String reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
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
	public String getReportGoodsContent() {
		return reportGoodsContent;
	}
	public void setReportGoodsContent(String reportGoodsContent) {
		this.reportGoodsContent = reportGoodsContent;
	}
	public String getReportGoodsDateTime() {
		return reportGoodsDateTime;
	}
	public void setReportGoodsDateTime(String reportGoodsDateTime) {
		this.reportGoodsDateTime = reportGoodsDateTime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportGoods [reportGoodsCode=");
		builder.append(reportGoodsCode);
		builder.append(", reportTypeCode=");
		builder.append(reportTypeCode);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", reportStateCode=");
		builder.append(reportStateCode);
		builder.append(", reportingUserId=");
		builder.append(reportingUserId);
		builder.append(", reportedUserId=");
		builder.append(reportedUserId);
		builder.append(", reportGoodsContent=");
		builder.append(reportGoodsContent);
		builder.append(", reportGoodsDateTime=");
		builder.append(reportGoodsDateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
