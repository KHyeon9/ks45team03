package ks45team03.rentravel.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.mapper.AdminUserMapper;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.dto.UserLevel;

@Service
@Transactional
public class AdminUserService {
	
	// 의준성 주입
	private final AdminUserMapper adminUserMapper;
	
	public AdminUserService(AdminUserMapper adminUserMapper) {
		this.adminUserMapper = adminUserMapper;
	}
	
	public List<User> userList(){
		return adminUserMapper.userList();
	}
	
	// 수정 처리
	public int modifyUser(User user) {
		
		int result = adminUserMapper.modifyUser(user);
		
		return result;
	}
	
	// 특정 회원 조회(수정)
	public User getUserInfoById(String userId) {
		
		User userInfo = adminUserMapper.getUserInfoById(userId);
		
		return userInfo;
	}
	
	// 회원 등급 조회
	public List<UserLevel> getUserLevelList() {
		List<UserLevel> userLevelList = adminUserMapper.getUserLevelList();
		return userLevelList;
	}
}
