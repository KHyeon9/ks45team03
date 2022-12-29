package ks45team03.rentravel.dto;

public class MileageUse {

	private String mileageUseCode;
	private String userId;
	private String paymentCode;
	private String mileageUseAmount;
	private String mileageUseTime;
	private String mileageGroupCode;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MileageUse [mileageUseCode=");
		builder.append(mileageUseCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", paymentCode=");
		builder.append(paymentCode);
		builder.append(", mileageUseAmount=");
		builder.append(mileageUseAmount);
		builder.append(", mileageUseTime=");
		builder.append(mileageUseTime);
		builder.append(", mileageGroupCode=");
		builder.append(mileageGroupCode);
		builder.append("]");
		return builder.toString();
	}
	public String getMileageUseCode() {
		return mileageUseCode;
	}
	public void setMileageUseCode(String mileageUseCode) {
		this.mileageUseCode = mileageUseCode;
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
	public String getMileageUseAmount() {
		return mileageUseAmount;
	}
	public void setMileageUseAmount(String mileageUseAmount) {
		this.mileageUseAmount = mileageUseAmount;
	}
	public String getMileageUseTime() {
		return mileageUseTime;
	}
	public void setMileageUseTime(String mileageUseTime) {
		this.mileageUseTime = mileageUseTime;
	}
	public String getMileageGroupCode() {
		return mileageGroupCode;
	}
	public void setMileageGroupCode(String mileageGroupCode) {
		this.mileageGroupCode = mileageGroupCode;
	}
}
