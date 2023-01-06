package ks45team03.rentravel.dto;

public class InquiryBoard {
	
	private String inquiryBoardCode;
	private String userId;
	private String inquiryBoardTitle;
	private String inquiryBoardContent;
	private String inquiryBoardType;
	private String inquiryBoardRegTime;
	
	private String inquiryReBoardCode;
	private String inquiryId;
	private String inquiryReBoardTitle;
	private String inquiryReBoardContent;
	private String inquiryBoardReRegTime;
	
	private User user;

	public String getInquiryBoardCode() {
		return inquiryBoardCode;
	}

	public void setInquiryBoardCode(String inquiryBoardCode) {
		this.inquiryBoardCode = inquiryBoardCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInquiryBoardTitle() {
		return inquiryBoardTitle;
	}

	public void setInquiryBoardTitle(String inquiryBoardTitle) {
		this.inquiryBoardTitle = inquiryBoardTitle;
	}

	public String getInquiryBoardContent() {
		return inquiryBoardContent;
	}

	public void setInquiryBoardContent(String inquiryBoardContent) {
		this.inquiryBoardContent = inquiryBoardContent;
	}

	public String getInquiryBoardType() {
		return inquiryBoardType;
	}

	public void setInquiryBoardType(String inquiryBoardType) {
		this.inquiryBoardType = inquiryBoardType;
	}

	public String getInquiryBoardRegTime() {
		return inquiryBoardRegTime;
	}

	public void setInquiryBoardRegTime(String inquiryBoardRegTime) {
		this.inquiryBoardRegTime = inquiryBoardRegTime;
	}

	public String getInquiryReBoardCode() {
		return inquiryReBoardCode;
	}

	public void setInquiryReBoardCode(String inquiryReBoardCode) {
		this.inquiryReBoardCode = inquiryReBoardCode;
	}

	public String getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(String inquiryId) {
		this.inquiryId = inquiryId;
	}

	public String getInquiryReBoardTitle() {
		return inquiryReBoardTitle;
	}

	public void setInquiryReBoardTitle(String inquiryReBoardTitle) {
		this.inquiryReBoardTitle = inquiryReBoardTitle;
	}

	public String getInquiryReBoardContent() {
		return inquiryReBoardContent;
	}

	public void setInquiryReBoardContent(String inquiryReBoardContent) {
		this.inquiryReBoardContent = inquiryReBoardContent;
	}

	public String getInquiryBoardReRegTime() {
		return inquiryBoardReRegTime;
	}

	public void setInquiryBoardReRegTime(String inquiryBoardReRegTime) {
		this.inquiryBoardReRegTime = inquiryBoardReRegTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "InquiryBoard [inquiryBoardCode=" + inquiryBoardCode + ", userId=" + userId + ", inquiryBoardTitle="
				+ inquiryBoardTitle + ", inquiryBoardContent=" + inquiryBoardContent + ", inquiryBoardType="
				+ inquiryBoardType + ", inquiryBoardRegTime=" + inquiryBoardRegTime + ", inquiryReBoardCode="
				+ inquiryReBoardCode + ", inquiryId=" + inquiryId + ", inquiryReBoardTitle=" + inquiryReBoardTitle
				+ ", inquiryReBoardContent=" + inquiryReBoardContent + ", inquiryBoardReRegTime="
				+ inquiryBoardReRegTime + ", user=" + user + "]";
	}

	
	


}
