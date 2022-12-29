package ks45team03.rentravel.dto;

public class MileageReviewSave {

	private String reviewMileageSaveCode;
	private String userId;
	private String reviewCode;
	private String mileageSaveAmount;
	private String mileageSaveTime;
	private String mileageGroupCode;
	public String getReviewMileageSaveCode() {
		return reviewMileageSaveCode;
	}
	public void setReviewMileageSaveCode(String reviewMileageSaveCode) {
		this.reviewMileageSaveCode = reviewMileageSaveCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
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
		builder.append("MileageReviewSave [reviewMileageSaveCode=");
		builder.append(reviewMileageSaveCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", reviewCode=");
		builder.append(reviewCode);
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
