package ks45team03.rentravel.dto;

public class InsuranceClaim {
	private String insuranceClaimCode;
	private String userId;
	private String insuranceRequestCode;
	private String insuranceRequestStateCode;
	private String insuranceClaimModifyDate;
	
	public String getInsuranceClaimCode() {
		return insuranceClaimCode;
	}
	public void setInsuranceClaimCode(String insuranceClaimCode) {
		this.insuranceClaimCode = insuranceClaimCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInsuranceRequestCode() {
		return insuranceRequestCode;
	}
	public void setInsuranceRequestCode(String insuranceRequestCode) {
		this.insuranceRequestCode = insuranceRequestCode;
	}
	public String getInsuranceRequestStateCode() {
		return insuranceRequestStateCode;
	}
	public void setInsuranceRequestStateCode(String insuranceRequestStateCode) {
		this.insuranceRequestStateCode = insuranceRequestStateCode;
	}
	public String getInsuranceClaimModifyDate() {
		return insuranceClaimModifyDate;
	}
	public void setInsuranceClaimModifyDate(String insuranceClaimModifyDate) {
		this.insuranceClaimModifyDate = insuranceClaimModifyDate;
	}
	@Override
	public String toString() {
		return "InsuranceClaim [insuranceClaimCode=" + insuranceClaimCode + ", userId=" + userId
				+ ", insuranceRequestCode=" + insuranceRequestCode + ", insuranceRequestStateCode="
				+ insuranceRequestStateCode + ", insuranceClaimModifyDate=" + insuranceClaimModifyDate + "]";
	}

	
	
}
