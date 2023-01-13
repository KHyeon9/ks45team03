package ks45team03.rentravel.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.CommisionRate;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.mapper.AdminCommisionRateMapper;

@Service
@Transactional
public class AdminCommisionRateService {

	private final AdminCommisionRateMapper adminCommisionRateMapper;
	
	public AdminCommisionRateService(AdminCommisionRateMapper adminCommisionRateMapper) {
		
		this.adminCommisionRateMapper = adminCommisionRateMapper;
	}
	

	
	/**
	 * 플랫폼 수수료율 수정
	 * @param commisionRate
	 * @return
	 */
	public int adminModifyCommisionRate (CommisionRate commisionRate) {
		
		int result = adminCommisionRateMapper.adminModifyCommisionRate(commisionRate);
		
		return result;
	}
	
	
	/**
	 * 특정 플랫폼 수수료율 조회 
	 * @param commisionRateCode
	 * @return
	 */
	public CommisionRate adminGetCommisionRateListByCode (String commisionRateCode) {
		
		CommisionRate commisionRateInfo =  adminCommisionRateMapper.adminGetCommisionRateListByCode(commisionRateCode);
		
		return commisionRateInfo;
	}
	
	
	/**
	 * 플랫폼 수수료율 추가
	 * @param commisionRate
	 */
	public void adminAddCommisionRate (CommisionRate commisionRate) {
		
		adminCommisionRateMapper.adminAddCommisionRate(commisionRate);
	}
	
	
	
}
