package ks45team03.rentravel.dto;

public class MileageSaveUse {

	private String mileageSaveUseCode;
	private String userId;
	private String mileageChange;
	private String totalMileage;
	private String mileageChangeTime;
	private String mileageChangeReason;
	private String saveUseType;
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
	public String getMileageChange() {
		return mileageChange;
	}
	public void setMileageChange(String mileageChange) {
		this.mileageChange = mileageChange;
	}
	public String getTotalMileage() {
		return totalMileage;
	}
	public void setTotalMileage(String totalMileage) {
		this.totalMileage = totalMileage;
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
	public String getSaveUseType() {
		return saveUseType;
	}
	public void setSaveUseType(String saveUseType) {
		this.saveUseType = saveUseType;
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
		builder.append(totalMileage);
		builder.append(", mileageChangeTime=");
		builder.append(mileageChangeTime);
		builder.append(", mileageChangeReason=");
		builder.append(mileageChangeReason);
		builder.append(", saveUseType=");
		builder.append(saveUseType);
		builder.append(", mileageGroupCode=");
		builder.append(mileageGroupCode);
		builder.append(", mileageDayFinish=");
		builder.append(mileageDayFinish);
		builder.append("]");
		return builder.toString();
	}
}
