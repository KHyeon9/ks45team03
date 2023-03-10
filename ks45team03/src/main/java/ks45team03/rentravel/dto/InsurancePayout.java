package ks45team03.rentravel.dto;

public class InsurancePayout {
	private String insurancePayoutCode;
	private String userId;
	private String insuranceBillDetailCode;
	private String insuranceBillCode;
	private int insurancePayoutPrice;
	private String insurancePayoutDate;
	
	Insurance insurance;
	Goods goods;
	InsuranceBillDetail insuranceBillDetail;
	
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public InsuranceBillDetail getInsuranceBillDetail() {
		return insuranceBillDetail;
	}
	public void setInsuranceBillDetail(InsuranceBillDetail insuranceBillDetail) {
		this.insuranceBillDetail = insuranceBillDetail;
	}
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
	public String getInsuranceBillDetailCode() {
		return insuranceBillDetailCode;
	}
	public void setInsuranceBillDetailCode(String insuranceBillDetailCode) {
		this.insuranceBillDetailCode = insuranceBillDetailCode;
	}
	public String getInsuranceBillCode() {
		return insuranceBillCode;
	}
	public void setInsuranceBillCode(String insuranceBillCode) {
		this.insuranceBillCode = insuranceBillCode;
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
				+ ", insuranceBillDetailCode=" + insuranceBillDetailCode + ", insuranceBillCode=" + insuranceBillCode
				+ ", insurancePayoutPrice=" + insurancePayoutPrice + ", insurancePayoutDate=" + insurancePayoutDate
				+ "]";
	}
	
	
}