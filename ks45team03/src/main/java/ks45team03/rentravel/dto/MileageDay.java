package ks45team03.rentravel.dto;

public class MileageDay {

	private String mileageDayCode;
	private String userId;
	private String mileageChangeDate;
	private String mileageSaveYear;
	private String mileageDayTotal;
	private String mileageGroupCode;
	private String mileageMonthGroup;
	public String getMileageDayCode() {
		return mileageDayCode;
	}
	public void setMileageDayCode(String mileageDayCode) {
		this.mileageDayCode = mileageDayCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMileageChangeDate() {
		return mileageChangeDate;
	}
	public void setMileageChangeDate(String mileageChangeDate) {
		this.mileageChangeDate = mileageChangeDate;
	}
	public String getMileageSaveYear() {
		return mileageSaveYear;
	}
	public void setMileageSaveYear(String mileageSaveYear) {
		this.mileageSaveYear = mileageSaveYear;
	}
	public String getMileageDayTotal() {
		return mileageDayTotal;
	}
	public void setMileageDayTotal(String mileageDayTotal) {
		this.mileageDayTotal = mileageDayTotal;
	}
	public String getMileageGroupCode() {
		return mileageGroupCode;
	}
	public void setMileageGroupCode(String mileageGroupCode) {
		this.mileageGroupCode = mileageGroupCode;
	}
	public String getMileageMonthGroup() {
		return mileageMonthGroup;
	}
	public void setMileageMonthGroup(String mileageMonthGroup) {
		this.mileageMonthGroup = mileageMonthGroup;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MileageDay [mileageDayCode=");
		builder.append(mileageDayCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", mileageChangeDate=");
		builder.append(mileageChangeDate);
		builder.append(", mileageSaveYear=");
		builder.append(mileageSaveYear);
		builder.append(", mileageDayTotal=");
		builder.append(mileageDayTotal);
		builder.append(", mileageGroupCode=");
		builder.append(mileageGroupCode);
		builder.append(", mileageMonthGroup=");
		builder.append(mileageMonthGroup);
		builder.append("]");
		return builder.toString();
	}
	
}
