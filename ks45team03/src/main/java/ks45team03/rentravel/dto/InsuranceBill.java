package ks45team03.rentravel.dto;

public class InsuranceBill {
	
	private String insuranceBillCode;
	private String userId;
	private String insuranceBillDetailCode;
	private String insuranceBillStateCode;
	private String insuranceBillModifyDate;
	
	public String getInsuranceBillCode() {
		return insuranceBillCode;
	}
	public void setInsuranceBillCode(String insuranceBillCode) {
		this.insuranceBillCode = insuranceBillCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInsuranceBillDetailCode() {
		return insuranceBillDetailCode;
	}
	public void setInsuranceBillDetailCode(String insuranceBillDetailCode) {
		this.insuranceBillDetailCode = insuranceBillDetailCode;
	}
	public String getInsuranceBillStateCode() {
		return insuranceBillStateCode;
	}
	public void setInsuranceBillStateCode(String insuranceBillStateCode) {
		this.insuranceBillStateCode = insuranceBillStateCode;
	}
	public String getInsuranceBillModifyDate() {
		return insuranceBillModifyDate;
	}
	public void setInsuranceBillModifyDate(String insuranceBillModifyDate) {
		this.insuranceBillModifyDate = insuranceBillModifyDate;
	}
	
	@Override
	public String toString() {
		return "InsuranceBill [insuranceBillCode=" + insuranceBillCode + ", userId=" + userId
				+ ", insuranceBillDetailCode=" + insuranceBillDetailCode + ", insuranceBillStateCode="
				+ insuranceBillStateCode + ", insuranceBillModifyDate=" + insuranceBillModifyDate + "]";
	}
	
	
}
