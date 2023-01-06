package ks45team03.rentravel.dto;

public class Room {
	private int roomNumber;
	private String roomName;
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room [roomNumber=");
		builder.append(roomNumber);
		builder.append(", roomName=");
		builder.append(roomName);
		builder.append("]");
		return builder.toString();
	}
	
}
