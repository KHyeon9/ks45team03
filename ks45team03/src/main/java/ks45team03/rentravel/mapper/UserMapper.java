package ks45team03.rentravel.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.RegionSgg;
import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.dto.User;

@Mapper
public interface UserMapper {
	
	// 비밀번호 일치
	public User checkPwByUserId(String userId);
	
	public User userInfo(String loginId);
	
	public int addUser(User user);
	
	public List<RegionSido> getRegionSido();
	
	public List<RegionSgg> selectRegionSgg(String project);
	
	public boolean checkUserId(String userId);
	
	public boolean checkUserNickName(String userNickName);
}
