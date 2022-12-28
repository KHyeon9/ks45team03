package ks45team03.rentravel.dto;

public class InfoBoard {
	private String infoBoardCode;
	private String userId;
	private String infoBoardTitle;
	private String infoBoardContent;
	private int infoBoardLikeCnt;
	private int infoBoardViewCnt;
	private String infoBoardRegTime;
	private User user;

	
	public String getInfoBoardCode() {
		return infoBoardCode;
	}


	public void setInfoBoardCode(String infoBoardCode) {
		this.infoBoardCode = infoBoardCode;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInfoBoardTitle() {
		return infoBoardTitle;
	}

	public void setInfoBoardTitle(String infoBoardTitle) {
		this.infoBoardTitle = infoBoardTitle;
	}

	public String getInfoBoardContent() {
		return infoBoardContent;
	}

	public void setInfoBoardContent(String infoBoardContent) {
		this.infoBoardContent = infoBoardContent;
	}

	public int getInfoBoardLikeCnt() {
		return infoBoardLikeCnt;
	}

	public void setInfoBoardLikeCnt(int infoBoardLikeCnt) {
		this.infoBoardLikeCnt = infoBoardLikeCnt;
	}

	public int getInfoBoardViewCnt() {
		return infoBoardViewCnt;
	}

	public void setInfoBoardViewCnt(int infoBoardViewCnt) {
		this.infoBoardViewCnt = infoBoardViewCnt;
	}

	public String getInfoBoardRegTime() {
		return infoBoardRegTime;
	}




	public void setInfoBoardRegTime(String infoBoardRegTime) {
		this.infoBoardRegTime = infoBoardRegTime;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InfoBoard [infoBoardCode=");
		builder.append(infoBoardCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", infoBoardTitle=");
		builder.append(infoBoardTitle);
		builder.append(", infoBoardContent=");
		builder.append(infoBoardContent);
		builder.append(", infoBoardLikeCnt=");
		builder.append(infoBoardLikeCnt);
		builder.append(", infoBoardViewCnt=");
		builder.append(infoBoardViewCnt);
		builder.append(", infoBoardRegTime=");
		builder.append(infoBoardRegTime);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
	
}
