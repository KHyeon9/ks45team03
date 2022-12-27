package ks45team03.rentravel.dto;

public class InsurancePayout {
	private String insurancePayoutCode;
	private String userId;
	private String insuranceRequestCode;
	private String insuranceClaimCode;
	private int insurancePayoutPrice;
	private String insurancePayoutDate;
	
	public String getInsurancePayoutCode() {
		return insurancePayoutCode;
	}
	public void setInsurancePayoutCode(String insurancePayoutCode) {
		this.insurancePayoutCode = insurancePayoutCode;
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
	public String getInsuranceClaimCode() {
		return insuranceClaimCode;
	}
	public void setInsuranceClaimCode(String insuranceClaimCode) {
		this.insuranceClaimCode = insuranceClaimCode;
	}
	public int getInsurancePayoutPrice() {
		return insurancePayoutPrice;
	}
	public void setInsurancePayoutPrice(int insurancePayoutPrice) {
		this.insurancePayoutPrice = insurancePayoutPrice;
	}
	public String getInsurancePayoutDate() {
		return insurancePayoutDate;
	}
	public void setInsurancePayoutDate(String insurancePayoutDate) {
		this.insurancePayoutDate = insurancePayoutDate;
	}
	
	@Override
	public String toString() {
		return "InsurancePayout [insurancePayoutCode=" + insurancePayoutCode + ", userId=" + userId
				+ ", insuranceRequestCode=" + insuranceRequestCode + ", insuranceClaimCode=" + insuranceClaimCode
				+ ", insurancePayoutPrice=" + insurancePayoutPrice + ", insurancePayoutDate=" + insurancePayoutDate
				+ "]";
	}
	
}