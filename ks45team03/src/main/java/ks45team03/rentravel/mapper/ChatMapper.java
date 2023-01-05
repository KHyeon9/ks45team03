package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.ChatMessage;
import ks45team03.rentravel.dto.ChatRoom;

@Mapper
public interface ChatMapper {
	public List<ChatRoom> getChatRoomList(String loginId);
	
	public ChatRoom getChatRoomCode(String chatRoomCode);
	
	public int addChatMessage(ChatMessage chatMessage);
	
	public List<ChatMessage> getChatMessageList(String chatRoomCode);
	
	public int addChatRoom(ChatRoom chatRoom);
	
	public ChatRoom checkChatRoom(ChatRoom chatRoom);
	
	public int modifyChatReadCheck(String chatRoomCode, String loginId);
}
