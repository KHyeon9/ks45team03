package ks45team03.rentravel.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.mapper.UserMapper;

@Service
@Transactional
public class UserService {
	
	private final UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
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
}
