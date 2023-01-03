package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.ChatRoom;

@Mapper
public interface ChatMapper {
	public List<ChatRoom> getChatRoomList(String loginId);
}
