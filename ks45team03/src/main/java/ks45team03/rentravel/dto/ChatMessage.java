package ks45team03.rentravel.dto;

public class ChatMessage {
	private String chatMessageCode;
	private String userId;
	private String chatRoomCode;
	private String chatMessage;
	private String readCheck;
	private String messageSendTime;
	
	public String getChatMessageCode() {
		return chatMessageCode;
	}
	public void setChatMessageCode(String chatMessageCode) {
		this.chatMessageCode = chatMessageCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChatRoomCode() {
		return chatRoomCode;
	}
	public void setChatRoomCode(String chatRoomCode) {
		this.chatRoomCode = chatRoomCode;
	}
	public String getChatMessage() {
		return chatMessage;
	}
	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}
	public String getReadCheck() {
		return readCheck;
	}
	public void setReadCheck(String readCheck) {
		this.readCheck = readCheck;
	}
	public String getMessageSendTime() {
		return messageSendTime;
	}
	public void setMessageSendTime(String messageSendTime) {
		this.messageSendTime = messageSendTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatMessage [chatMessageCode=");
		builder.append(chatMessageCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", chatRoomCode=");
		builder.append(chatRoomCode);
		builder.append(", chatMessage=");
		builder.append(chatMessage);
		builder.append(", readCheck=");
		builder.append(readCheck);
		builder.append(", messageSendTime=");
		builder.append(messageSendTime);
		builder.append("]");
		return builder.toString();
	}
	
}
