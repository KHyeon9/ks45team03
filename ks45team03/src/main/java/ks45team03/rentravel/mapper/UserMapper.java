package ks45team03.rentravel.mapper;


import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.User;

@Mapper
public interface UserMapper {
	
	public User checkPwByUserId(String userId);

}
