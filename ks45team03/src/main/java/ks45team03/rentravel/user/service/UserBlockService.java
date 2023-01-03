package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.mapper.UserBlockMapper;

@Service
@Transactional
public class UserBlockService {
	
	private final UserBlockMapper userBlockMapper;
	
	public UserBlockService (UserBlockMapper userBlockMapper) {
		this.userBlockMapper = userBlockMapper;
	}
	
	
	
	public void addUserBlock (String userId, String loginId) {
		
		userBlockMapper.addUserBlock(userId, loginId);
	}
}
