package ks45team03.rentravel.dto;

public class MileagePaymentSave {

	private String mileagePaymentSaveCode;
	private String userId;
	private String paymentCode;
	private String mileageSaveAmount;
	private String mileageSaveTime;
	private String mileageGroupCode;
	
	public String getMileagePaymentSaveCode() {
		return mileagePaymentSaveCode;
	}
	public void setMileagePaymentSaveCode(String mileagePaymentSaveCode) {
		this.mileagePaymentSaveCode = mileagePaymentSaveCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getMileageSaveAmount() {
		return mileageSaveAmount;
	}
	public void setMileageSaveAmount(String mileageSaveAmount) {
		this.mileageSaveAmount = mileageSaveAmount;
	}
	public String getMileageSaveTime() {
		return mileageSaveTime;
	}
	public void setMileageSaveTime(String mileageSaveTime) {
		this.mileageSaveTime = mileageSaveTime;
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
		builder.append("MileagePaymentSave [mileagePaymentSaveCode=");
		builder.append(mileagePaymentSaveCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", paymentCode=");
		builder.append(paymentCode);
		builder.append(", mileageSaveAmount=");
		builder.append(mileageSaveAmount);
		builder.append(", mileageSaveTime=");
		builder.append(mileageSaveTime);
		builder.append(", mileageGroupCode=");
		builder.append(mileageGroupCode);
		builder.append("]");
		return builder.toString();
	}
	
}
