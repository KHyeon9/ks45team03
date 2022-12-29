package ks45team03.rentravel.dto;

public class ReportType {

	private String reportTypeCode;
	private String reportType;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportType [reportTypeCode=");
		builder.append(reportTypeCode);
		builder.append(", reportType=");
		builder.append(reportType);
		builder.append("]");
		return builder.toString();
	}
	public String getReportTypeCode() {
		return reportTypeCode;
	}
	public void setReportTypeCode(String reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
}
