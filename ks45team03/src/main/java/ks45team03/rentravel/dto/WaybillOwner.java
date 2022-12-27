package ks45team03.rentravel.dto;

public class WaybillOwner {
	private String waybillRenterCode;
	private String renterId;
	private String ownerId;
	private String paymentCode;
	private String courierName;
	private String waybillNumber;
	private String waybillRegDate;
	
	
	public String getWaybillRenterCode() {
		return waybillRenterCode;
	}
	public void setWaybillRenterCode(String waybillRenterCode) {
		this.waybillRenterCode = waybillRenterCode;
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
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	public String getWaybillNumber() {
		return waybillNumber;
	}
	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}
	public String getWaybillRegDate() {
		return waybillRegDate;
	}
	public void setWaybillRegDate(String waybillRegDate) {
		this.waybillRegDate = waybillRegDate;
	}
	
}
