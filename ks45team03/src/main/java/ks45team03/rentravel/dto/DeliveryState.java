package ks45team03.rentravel.dto;

public class DeliveryState {
	private String deliveryStateCode;
	private String userId;
	private String rentalCode;
	private String tradeStatusCode;
	private String rentalStateModifyDate;
	
	public String getDeliveryStateCode() {
		return deliveryStateCode;
	}
	public void setDeliveryStateCode(String deliveryStateCode) {
		this.deliveryStateCode = deliveryStateCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(String rentalCode) {
		this.rentalCode = rentalCode;
	}
	public String getTradeStatusCode() {
		return tradeStatusCode;
	}
	public void setTradeStatusCode(String tradeStatusCode) {
		this.tradeStatusCode = tradeStatusCode;
	}
	public String getRentalStateModifyDate() {
		return rentalStateModifyDate;
	}
	public void setRentalStateModifyDate(String rentalStateModifyDate) {
		this.rentalStateModifyDate = rentalStateModifyDate;
	}
	
}
