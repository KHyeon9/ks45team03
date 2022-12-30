package ks45team03.rentravel.dto;

public class Review {
	private String reviewCode;
	private String goodsCode;
	private String userId;
	private String reviewContent;
	private int goodsEvaluation;
	private String reviewImg;
	private String reviewRegDate;
	private String mileageGroupCode;
	private String saveMileage;
	
	private String goodsName;

	public String getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getGoodsEvaluation() {
		return goodsEvaluation;
	}

	public void setGoodsEvaluation(int goodsEvaluation) {
		this.goodsEvaluation = goodsEvaluation;
	}

	public String getReviewImg() {
		return reviewImg;
	}

	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}

	public String getReviewRegDate() {
		return reviewRegDate;
	}

	public void setReviewRegDate(String reviewRegDate) {
		this.reviewRegDate = reviewRegDate;
	}

	public String getMileageGroupCode() {
		return mileageGroupCode;
	}

	public void setMileageGroupCode(String mileageGroupCode) {
		this.mileageGroupCode = mileageGroupCode;
	}

	public String getSaveMileage() {
		return saveMileage;
	}

	public void setSaveMileage(String saveMileage) {
		this.saveMileage = saveMileage;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [reviewCode=");
		builder.append(reviewCode);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", reviewContent=");
		builder.append(reviewContent);
		builder.append(", goodsEvaluation=");
		builder.append(goodsEvaluation);
		builder.append(", reviewImg=");
		builder.append(reviewImg);
		builder.append(", reviewRegDate=");
		builder.append(reviewRegDate);
		builder.append(", mileageGroupCode=");
		builder.append(mileageGroupCode);
		builder.append(", saveMileage=");
		builder.append(saveMileage);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append("]");
		return builder.toString();
	}
	
}
