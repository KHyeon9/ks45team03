package ks45team03.rentravel.dto;

public class Return {
	private String returnCode;
	private String ownerId;
	private String renterId;
	private String rentalCode;
	private String paymentCode;
	private String returnDate;
	
	private String goodsName;
	private String rentalStartDate;
	private String rentalEndDate;
	private String tradeStatusCode;
	private String orderStateName;
	
	
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getRenterId() {
		return renterId;
	}
	public void setRenterId(String renterId) {
		this.renterId = renterId;
	}
	public String getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(String rentalCode) {
		this.rentalCode = rentalCode;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
	public String getOrderStateName() {
		return orderStateName;
	}
	public void setOrderStateName(String orderStateName) {
		this.orderStateName = orderStateName;
	}
	public String getTradeStatusCode() {
		return tradeStatusCode;
	}
	public void setTradeStatusCode(String tradeStatusCode) {
		this.tradeStatusCode = tradeStatusCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Return [returnCode=");
		builder.append(returnCode);
		builder.append(", ownerId=");
		builder.append(ownerId);
		builder.append(", renterId=");
		builder.append(renterId);
		builder.append(", rentalCode=");
		builder.append(rentalCode);
		builder.append(", paymentCode=");
		builder.append(paymentCode);
		builder.append(", returnDate=");
		builder.append(returnDate);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", rentalStartDate=");
		builder.append(rentalStartDate);
		builder.append(", rentalEndDate=");
		builder.append(rentalEndDate);
		builder.append(", tradeStatusCode=");
		builder.append(tradeStatusCode);
		builder.append(", orderStateName=");
		builder.append(orderStateName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
