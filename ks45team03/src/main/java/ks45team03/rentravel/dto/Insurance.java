package ks45team03.rentravel.dto;

public class Insurance {
	private String insuranceCode;
	private String userId;
	private String goodsCode;
	private String paymentCode;
	private String rentalCode;
	private String insuranceAvailable;
	private String insuranceSignUpTime;
	
	public String getInsuranceCode() {
		return insuranceCode;
	}
	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(String rentalCode) {
		this.rentalCode = rentalCode;
	}
	public String getInsuranceAvailable() {
		return insuranceAvailable;
	}
	public void setInsuranceAvailable(String insuranceAvailable) {
		this.insuranceAvailable = insuranceAvailable;
	}
	public String getInsuranceSignUpTime() {
		return insuranceSignUpTime;
	}
	public void setInsuranceSignUpTime(String insuranceSignUpTime) {
		this.insuranceSignUpTime = insuranceSignUpTime;
	}
	@Override
	public String toString() {
		return "Insurance [insuranceCode=" + insuranceCode + ", userId=" + userId + ", goodsCode=" + goodsCode
				+ ", paymentCode=" + paymentCode + ", rentalCode=" + rentalCode + ", insuranceAvailable="
				+ insuranceAvailable + ", insuranceSignUpTime=" + insuranceSignUpTime + "]";
	}

	
}
