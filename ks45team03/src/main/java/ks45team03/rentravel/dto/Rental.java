package ks45team03.rentravel.dto;

public class Rental {
	private String rentalCode;
	private String goodsCode;
	private String userId;
	private String rentalStartDate;
	private String rentalEndDate;
	private String selectDelivery;
	private String rentalOrderDate;
	
	public String getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(String rentalCode) {
		this.rentalCode = rentalCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRentalStartDate() {
		return rentalStartDate;
	}
	public void setRentalStartDate(String rentalStartDate) {
		this.rentalStartDate = rentalStartDate;
	}
	public String getRentalEndDate() {
		return rentalEndDate;
	}
	public void setRentalEndDate(String rentalEndDate) {
		this.rentalEndDate = rentalEndDate;
	}
	public String getSelectDelivery() {
		return selectDelivery;
	}
	public void setSelectDelivery(String selectDelivery) {
		this.selectDelivery = selectDelivery;
	}
	public String getRentalOrderDate() {
		return rentalOrderDate;
	}
	public void setRentalOrderDate(String rentalOrderDate) {
		this.rentalOrderDate = rentalOrderDate;
	}
	
}
