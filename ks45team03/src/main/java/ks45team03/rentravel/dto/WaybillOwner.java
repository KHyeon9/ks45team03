package ks45team03.rentravel.dto;

import lombok.ToString;

@ToString
public class WaybillOwner {
	private String waybillOwnerCode;
	private String ownerId;
	private String renterId;
	private String paymentCode;
	private String courierName;
	private String waybillNumber;
	private String waybillRegDate;
	
	
	public String getWaybillOwnerCode() {
		return waybillOwnerCode;
	}
	public void setWaybillOwnerCode(String waybillOwnerCode) {
		this.waybillOwnerCode = waybillOwnerCode;
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
