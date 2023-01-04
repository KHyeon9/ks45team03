package ks45team03.rentravel.mapper;


import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.User;

@Mapper
public interface UserMapper {
	
	// 비밀번호 일치
	public User checkPwByUserId(String userId);
	
	public User userInfo(String loginId);
	
}
