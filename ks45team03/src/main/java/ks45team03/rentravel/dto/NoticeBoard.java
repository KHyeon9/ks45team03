package ks45team03.rentravel.dto;

public class NoticeBoard {
	
	private String noticeBoardCode;
	private int num;
	private String userId;
	private String noticeBoardTitle;
	private String noticeBoardContent;
	private String noticeBoardFile;
	private String noticeBoardLikeCnt;
	private String noticeBoardViewCnt;
	private String noticeBoardRegTime;
	
	public String getNoticeBoardCode() {
		return noticeBoardCode;
	}
	public void setNoticeBoardCode(String noticeBoardCode) {
		this.noticeBoardCode = noticeBoardCode;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNoticeBoardTitle() {
		return noticeBoardTitle;
	}
	public void setNoticeBoardTitle(String noticeBoardTitle) {
		this.noticeBoardTitle = noticeBoardTitle;
	}
	public String getNoticeBoardContent() {
		return noticeBoardContent;
	}
	public void setNoticeBoardContent(String noticeBoardContent) {
		this.noticeBoardContent = noticeBoardContent;
	}
	public String getNoticeBoardFile() {
		return noticeBoardFile;
	}
	public void setNoticeBoardFile(String noticeBoardFile) {
		this.noticeBoardFile = noticeBoardFile;
	}
	public String getNoticeBoardLikeCnt() {
		return noticeBoardLikeCnt;
	}
	public void setNoticeBoardLikeCnt(String noticeBoardLikeCnt) {
		this.noticeBoardLikeCnt = noticeBoardLikeCnt;
	}
	public String getNoticeBoardViewCnt() {
		return noticeBoardViewCnt;
	}
	public void setNoticeBoardViewCnt(String noticeBoardViewCnt) {
		this.noticeBoardViewCnt = noticeBoardViewCnt;
	}
	public String getNoticeBoardRegTime() {
		return noticeBoardRegTime;
	}
	public void setNoticeBoardRegTime(String noticeBoardRegTime) {
		this.noticeBoardRegTime = noticeBoardRegTime;
	}
	@Override
	public String toString() {
		return "NoticeBoard [noticeBoardCode=" + noticeBoardCode + ", num=" + num + ", userId=" + userId
				+ ", noticeBoardTitle=" + noticeBoardTitle + ", noticeBoardContent=" + noticeBoardContent
				+ ", noticeBoardFile=" + noticeBoardFile + ", noticeBoardLikeCnt=" + noticeBoardLikeCnt
				+ ", noticeBoardViewCnt=" + noticeBoardViewCnt + ", noticeBoardRegTime=" + noticeBoardRegTime + "]";
	}
}
