package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.ChatMessage;
import ks45team03.rentravel.dto.ChatRoom;
import ks45team03.rentravel.mapper.ChatMapper;

@Service
public class ChatService {
	
	private final ChatMapper chatMapper;
	
	public ChatService(ChatMapper chatMapper) {
		this.chatMapper = chatMapper;
	}
	
	public List<ChatRoom> getChatRoomList(String loginId,int startIndex, int pageSize){
		
		List<ChatRoom> chatRoomList = chatMapper.getChatRoomList(loginId,startIndex,pageSize);
		
		return chatRoomList;
	}
	
	public int addChatMessage(ChatMessage chatMessage) {
		
		return chatMapper.addChatMessage(chatMessage);
	}
	
	public List<ChatMessage> getChatMessageList(String chatRoomCode){
		
		List<ChatMessage> chatMessageList = chatMapper.getChatMessageList(chatRoomCode);
		
		return chatMessageList;
	}
	
	public int addChatRoom(ChatRoom chatRoom) {
		
		return chatMapper.addChatRoom(chatRoom);
	}
	
	public ChatRoom checkChatRoom(ChatRoom chatRoom) {
		
		ChatRoom checkChatRoom = chatMapper.checkChatRoom(chatRoom);
		
		return checkChatRoom;
	}
	
	public int modifyChatReadCheck(String chatRoomCode, String loginId){
		
		int modifyChatReadCheck = chatMapper.modifyChatReadCheck(chatRoomCode, loginId);
		
		return modifyChatReadCheck;
	}
	
	public int getChatRoomListCount(String loginId) {
		
		int chatRoomListCount = chatMapper.getChatRoomListCount(loginId);
		
		return chatRoomListCount;
	}
	
	public int removeChatMessage(String chatRoomCode) {
		int removeChatMessage = chatMapper.removeChatMessage(chatRoomCode);
		return removeChatMessage;
	}
	public int removeChatRoom(String chatRoomCode) {
		int removeChatRoom = chatMapper.removeChatRoom(chatRoomCode);
		return removeChatRoom;
	}
}
