package ks45team03.rentravel.dto;

public class Rental {
	private String rentalCode;
	private String goodsCode;
	private String userId;
	private String rentalStartDate;
	private String rentalEndDate;
	private String selectDelivery;
	private String rentalOrderDate;
	private String goodsName;
	private String sigunguName;
	private String orderStateName;
	private Payment payment;
	
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
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getSigunguName() {
		return sigunguName;
	}
	public void setSigunguName(String sigunguName) {
		this.sigunguName = sigunguName;
	}
	public String getOrderStateName() {
		return orderStateName;
	}
	public void setOrderStateName(String orderStateName) {
		this.orderStateName = orderStateName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rental [rentalCode=");
		builder.append(rentalCode);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", rentalStartDate=");
		builder.append(rentalStartDate);
		builder.append(", rentalEndDate=");
		builder.append(rentalEndDate);
		builder.append(", selectDelivery=");
		builder.append(selectDelivery);
		builder.append(", rentalOrderDate=");
		builder.append(rentalOrderDate);
		builder.append(", payment=");
		builder.append(payment);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", sigunguName=");
		builder.append(sigunguName);
		builder.append(", orderStateName=");
		builder.append(orderStateName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
