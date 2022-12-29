package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.RegionSgg;
import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.mapper.UserMapper;

@Service
@Transactional
public class UserService {
	
	private final UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public List<RegionSido> regionSidoList(){
		
		List<RegionSido> regionSidoList = userMapper.regionSidoList();
		
		return regionSidoList;
	}
}
