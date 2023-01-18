package ks45team03.rentravel.dto;

public class RentalCancel {
	private String rentalCancelCode;
	private String cancelUserId;
	private String rentalCode;
	private String paymentCode;
	private String rentalCancelSignupDate;
	private String refundUserId;
	private String refundCancelSignupDate;
	private String ownerCancelSignupCheckDate;
	private String refundWay;
	private int refundMoney;
	private int mileageUsePrice;
	private int saveMileage;
	private String mileageGroupCode;
	
	public String getRentalCancelCode() {
		return rentalCancelCode;
	}
	public void setRentalCancelCode(String rentalCancelCode) {
		this.rentalCancelCode = rentalCancelCode;
	}
	public String getCancelUserId() {
		return cancelUserId;
	}
	public void setCancelUserId(String cancelUserId) {
		this.cancelUserId = cancelUserId;
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
	public String getRentalCancelSignupDate() {
		return rentalCancelSignupDate;
	}
	public void setRentalCancelSignupDate(String rentalCancelSignupDate) {
		this.rentalCancelSignupDate = rentalCancelSignupDate;
	}
	public String getRefundUserId() {
		return refundUserId;
	}
	public void setRefundUserId(String refundUserId) {
		this.refundUserId = refundUserId;
	}
	public String getRefundCancelSignupDate() {
		return refundCancelSignupDate;
	}
	public void setRefundCancelSignupDate(String refundCancelSignupDate) {
		this.refundCancelSignupDate = refundCancelSignupDate;
	}
	public String getOwnerCancelSignupCheckDate() {
		return ownerCancelSignupCheckDate;
	}
	public void setOwnerCancelSignupCheckDate(String ownerCancelSignupCheckDate) {
		this.ownerCancelSignupCheckDate = ownerCancelSignupCheckDate;
	}
	public String getRefundWay() {
		return refundWay;
	}
	public void setRefundWay(String refundWay) {
		this.refundWay = refundWay;
	}
	public int getRefundMoney() {
		return refundMoney;
	}
	public void setRefundMoney(int refundMoney) {
		this.refundMoney = refundMoney;
	}
	public int getMileageUsePrice() {
		return mileageUsePrice;
	}
	public void setMileageUsePrice(int mileageUsePrice) {
		this.mileageUsePrice = mileageUsePrice;
	}
	public int getSaveMileage() {
		return saveMileage;
	}
	public void setSaveMileage(int saveMileage) {
		this.saveMileage = saveMileage;
	}
	public String getMileageGroupCode() {
		return mileageGroupCode;
	}
	public void setMileageGroupCode(String mileageGroupCode) {
		this.mileageGroupCode = mileageGroupCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RentalCancel [rentalCancelCode=");
		builder.append(rentalCancelCode);
		builder.append(", cancelUserId=");
		builder.append(cancelUserId);
		builder.append(", rentalCode=");
		builder.append(rentalCode);
		builder.append(", paymentCode=");
		builder.append(paymentCode);
		builder.append(", rentalCancelSignupDate=");
		builder.append(rentalCancelSignupDate);
		builder.append(", refundUserId=");
		builder.append(refundUserId);
		builder.append(", refundCancelSignupDate=");
		builder.append(refundCancelSignupDate);
		builder.append(", ownerCancelSignupCheckDate=");
		builder.append(ownerCancelSignupCheckDate);
		builder.append(", refundWay=");
		builder.append(refundWay);
		builder.append(", refundMoney=");
		builder.append(refundMoney);
		builder.append(", mileageUsePrice=");
		builder.append(mileageUsePrice);
		builder.append(", saveMileage=");
		builder.append(saveMileage);
		builder.append(", mileageGroupCode=");
		builder.append(mileageGroupCode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
