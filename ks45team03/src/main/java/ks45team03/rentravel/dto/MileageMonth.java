package ks45team03.rentravel.dto;

public class MileageMonth {

	private String mileageMonthCode;
	private String userId;
	private String mileageChangeDate;
	private String mileageSaveYearMonth;
	private String mileageMonthGroup;
	private String mileageMonthTotal;
	public String getMileageMonthCode() {
		return mileageMonthCode;
	}
	public void setMileageMonthCode(String mileageMonthCode) {
		this.mileageMonthCode = mileageMonthCode;
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
	public String getMileageSaveYearMonth() {
		return mileageSaveYearMonth;
	}
	public void setMileageSaveYearMonth(String mileageSaveYearMonth) {
		this.mileageSaveYearMonth = mileageSaveYearMonth;
	}
	public String getMileageMonthGroup() {
		return mileageMonthGroup;
	}
	public void setMileageMonthGroup(String mileageMonthGroup) {
		this.mileageMonthGroup = mileageMonthGroup;
	}
	public String getMileageMonthTotal() {
		return mileageMonthTotal;
	}
	public void setMileageMonthTotal(String mileageMonthTotal) {
		this.mileageMonthTotal = mileageMonthTotal;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MileageMonth [mileageMonthCode=");
		builder.append(mileageMonthCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", mileageChangeDate=");
		builder.append(mileageChangeDate);
		builder.append(", mileageSaveYearMonth=");
		builder.append(mileageSaveYearMonth);
		builder.append(", mileageMonthGroup=");
		builder.append(mileageMonthGroup);
		builder.append(", mileageMonthTotal=");
		builder.append(mileageMonthTotal);
		builder.append("]");
		return builder.toString();
	}
	
}
