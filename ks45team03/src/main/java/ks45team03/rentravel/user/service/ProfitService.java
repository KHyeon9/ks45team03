package ks45team03.rentravel.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.mapper.UserProfitMapper;

@Service
@Transactional
public class ProfitService {

	private final UserProfitMapper userProfitMapper;
	
	public ProfitService (UserProfitMapper userProfitMapper) {
		
		this.userProfitMapper = userProfitMapper;
	}
	
	
}
