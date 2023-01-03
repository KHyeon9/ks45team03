package ks45team03.rentravel.dto;

public class ChatRoom {
	private String chatRoomCode;
	private String renterId;
	private String ownerId;
	private String chatRoomAddTime;
	
	public String getChatRoomCode() {
		return chatRoomCode;
	}
	public void setChatRoomCode(String chatRoomCode) {
		this.chatRoomCode = chatRoomCode;
	}
	public String getRenterId() {
		return renterId;
	}
	public void setRenterId(String renterId) {
		this.renterId = renterId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getChatRoomAddTime() {
		return chatRoomAddTime;
	}
	public void setChatRoomAddTime(String chatRoomAddTime) {
		this.chatRoomAddTime = chatRoomAddTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatRoom [chatRoomCode=");
		builder.append(chatRoomCode);
		builder.append(", renterId=");
		builder.append(renterId);
		builder.append(", ownerId=");
		builder.append(ownerId);
		builder.append(", chatRoomAddTime=");
		builder.append(chatRoomAddTime);
		builder.append("]");
		return builder.toString();
	}
	
}
