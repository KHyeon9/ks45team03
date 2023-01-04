package ks45team03.rentravel.dto;

public class InquiryBoard {
	
	private String inquiryBoardCode;
	private String userId;
	private String inquiryBoardTitle;
	private String inquiryBoardContent;
	private String inquiryBoardType;
	private String inquiryBoardRegTime;
	private User user;
	public String getInquiryBoardCode() {
		return inquiryBoardCode;
	}
	public void setInquiryBoardCode(String inquiryBoardCode) {
		this.inquiryBoardCode = inquiryBoardCode;
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
				+ inquiryBoardType + ", inquiryBoardRegTime=" + inquiryBoardRegTime + ", user=" + user + "]";
	}
	
	


}
