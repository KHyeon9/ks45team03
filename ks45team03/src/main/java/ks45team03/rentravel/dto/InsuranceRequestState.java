package ks45team03.rentravel.dto;

public class InsuranceRequestState {
	private String insuranceRequestStateCode;
	private String insuranceRequestStateName;
	
	public String getInsuranceRequestStateCode() {
		return insuranceRequestStateCode;
	}
	public void setInsuranceRequestStateCode(String insuranceRequestStateCode) {
		this.insuranceRequestStateCode = insuranceRequestStateCode;
	}
	public String getInsuranceRequestStateName() {
		return insuranceRequestStateName;
	}
	public void setInsuranceRequestStateName(String insuranceRequestStateName) {
		this.insuranceRequestStateName = insuranceRequestStateName;
	}
	@Override
	public String toString() {
		return "InsuranceRequestState [insuranceRequestStateCode=" + insuranceRequestStateCode
				+ ", insuranceRequestStateName=" + insuranceRequestStateName + "]";
	}
	
	

}
