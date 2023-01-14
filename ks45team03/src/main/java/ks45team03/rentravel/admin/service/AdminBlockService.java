package ks45team03.rentravel.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.CommisionRate;
import ks45team03.rentravel.mapper.AdminBlockMapper;

@Service
@Transactional
public class AdminBlockService {
	
	private final AdminBlockMapper adminBlockMapper;
	
	public AdminBlockService(AdminBlockMapper adminBlockMapper) {
		
		this.adminBlockMapper = adminBlockMapper;
	}


	
	
	
	/* 회원 차단 목록 조회 */
	public List<Block> adminGetUserBlockList (int startIndex, int pageSize, String searchKey, String searchValue){
						
		if(searchKey != null) {
			switch (searchKey) {
			case "blockCode":
				searchKey = "block_code";
				break;
			case "blockingUserId":
				searchKey = "blocking_user_id";
				break;	
			case "blockedUserId":
				searchKey = "blocked_user_id";
				break;	
			case "blockDate":
				searchKey = "block_date";
				break;	
			}
		}
		
		
		List<Block> adminGetUserBlockList = adminBlockMapper.adminGetUserBlockList(startIndex, pageSize, searchKey, searchValue);
		
		return adminGetUserBlockList;
		
	}
}
