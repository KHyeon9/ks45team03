package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.ChatRoom;
import ks45team03.rentravel.mapper.ChatMapper;

@Service
public class ChatService {
	
	private final ChatMapper chatMapper;
	
	public ChatService(ChatMapper chatMapper) {
		this.chatMapper = chatMapper;
	}
	
	public List<ChatRoom> getChatRoomList(String loginId){
		
		List<ChatRoom> chatRoomList = chatMapper.getChatRoomList(loginId);
		
		return chatRoomList;
	}
}
