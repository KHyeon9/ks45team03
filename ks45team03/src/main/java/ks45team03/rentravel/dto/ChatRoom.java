package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatRoom {
	private String chatRoomCode;
	private String renterId;
	private String ownerId;
	private String chatRoomAddTime;
	
	private String renterNickname;
	private String ownerNickname;
	
}
