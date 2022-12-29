package ks45team03.rentravel.dto;

public class ReportState {

	private String reportStateCode;
	private String reportStateName;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportState [reportStateCode=");
		builder.append(reportStateCode);
		builder.append(", reportStateName=");
		builder.append(reportStateName);
		builder.append("]");
		return builder.toString();
	}
	public String getReportStateCode() {
		return reportStateCode;
	}
	public void setReportStateCode(String reportStateCode) {
		this.reportStateCode = reportStateCode;
	}
	public String getReportStateName() {
		return reportStateName;
	}
	public void setReportStateName(String reportStateName) {
		this.reportStateName = reportStateName;
	}
}
