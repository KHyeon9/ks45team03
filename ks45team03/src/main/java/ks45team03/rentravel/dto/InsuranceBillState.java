package ks45team03.rentravel.dto;

public class InsuranceBillState {
	private String insuranceBillStateCode;
	private String insuranceBillStateName;
	
	public String getInsuranceBillStateCode() {
		return insuranceBillStateCode;
	}
	public void setInsuranceBillStateCode(String insuranceBillStateCode) {
		this.insuranceBillStateCode = insuranceBillStateCode;
	}
	public String getInsuranceBillStateName() {
		return insuranceBillStateName;
	}
	public void setInsuranceBillStateName(String insuranceBillStateName) {
		this.insuranceBillStateName = insuranceBillStateName;
	}
	@Override
	public String toString() {
		return "InsuranceBillState [insuranceBillStateCode=" + insuranceBillStateCode + ", insuranceBillStateName="
				+ insuranceBillStateName + "]";
	}
	
	
	

}
