package ks45team03.rentravel.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.RegionSgg;
import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.dto.UserEvaluation;
import ks45team03.rentravel.mapper.UserMapper;

@Service
@Transactional
public class UserService {
	
	private final UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public List<RegionSgg> selectRegionSgg(String project){
		
		List<RegionSgg> selectRegionSgg = userMapper.selectRegionSgg(project);
		
		return selectRegionSgg;
	}
	
	// 로그인 회원정보(비밀번호) 확인
	public Map<String, Object> checkPwByUserId(String userId, String userPw) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean result = false;
		
		User user = userMapper.checkPwByUserId(userId);
		if(user != null) {
			String checkPw = user.getUserPw();
			if(userPw.equals(checkPw)) {
				result = true;
			}
		}
		
		resultMap.put("result", result);
		resultMap.put("userInfo", user);
		
		return resultMap;
	}
	
	public Map<String, Object> userInfo(String userId){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		User user = userMapper.checkPwByUserId(userId);
		resultMap.put("userInfo", user);
		
		return resultMap;
	}
	
	public void addUser(User user) {
		
		userMapper.addUser(user);
	}
	
	public List<RegionSido> getRegionSido() {
		
		List<RegionSido> getRegionSido = userMapper.getRegionSido();
		
		return getRegionSido;
	}
	
	public int findIdCheck(String userName, String userEmail, String userPhoneNumber) {
		
		return userMapper.findIdCheck(userName, userEmail, userPhoneNumber);
	}
	
	public List<UserEvaluation> userEvaluation(String loginId){
		return userMapper.userEvaluation(loginId);
	}
	
	public List<UserEvaluation> userEvaluation2(String userNickName){
		return userMapper.userEvaluation2(userNickName);
	}
}
