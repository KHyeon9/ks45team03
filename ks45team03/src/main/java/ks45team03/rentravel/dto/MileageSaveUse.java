package ks45team03.rentravel.dto;

public class MileageSaveUse {

	private String mileageSaveUseCode;
	private String userId;
	private int mileageChange;
	private int mileageTotal;
	private String mileageChangeTime;
	private String mileageChangeReason;
	private String mileageSaveUseType;
	private String mileageGroupCode;
	private String mileageDayFinish;
	
	public String getMileageSaveUseCode() {
		return mileageSaveUseCode;
	}
	public void setMileageSaveUseCode(String mileageSaveUseCode) {
		this.mileageSaveUseCode = mileageSaveUseCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getMileageChange() {
		return mileageChange;
	}
	public void setMileageChange(int mileageChange) {
		this.mileageChange = mileageChange;
	}
	
	public String getMileageChangeTime() {
		return mileageChangeTime;
	}
	public void setMileageChangeTime(String mileageChangeTime) {
		this.mileageChangeTime = mileageChangeTime;
	}
	public String getMileageChangeReason() {
		return mileageChangeReason;
	}
	public void setMileageChangeReason(String mileageChangeReason) {
		this.mileageChangeReason = mileageChangeReason;
	}
	
	public int getMileageTotal() {
		return mileageTotal;
	}
	public void setMileageTotal(int mileageTotal) {
		this.mileageTotal = mileageTotal;
	}
	public String getMileageSaveUseType() {
		return mileageSaveUseType;
	}
	public void setMileageSaveUseType(String mileageSaveUseType) {
		this.mileageSaveUseType = mileageSaveUseType;
	}
	public String getMileageGroupCode() {
		return mileageGroupCode;
	}
	public void setMileageGroupCode(String mileageGroupCode) {
		this.mileageGroupCode = mileageGroupCode;
	}
	public String getMileageDayFinish() {
		return mileageDayFinish;
	}
	public void setMileageDayFinish(String mileageDayFinish) {
		this.mileageDayFinish = mileageDayFinish;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MileageSaveUse [mileageSaveUseCode=");
		builder.append(mileageSaveUseCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", mileageChange=");
		builder.append(mileageChange);
		builder.append(", totalMileage=");
		builder.append(mileageTotal);
		builder.append(", mileageChangeTime=");
		builder.append(mileageChangeTime);
		builder.append(", mileageChangeReason=");
		builder.append(mileageChangeReason);
		builder.append(", saveUseType=");
		builder.append(mileageSaveUseType);
		builder.append(", mileageGroupCode=");
		builder.append(mileageGroupCode);
		builder.append(", mileageDayFinish=");
		builder.append(mileageDayFinish);
		builder.append("]");
		return builder.toString();
	}
}
