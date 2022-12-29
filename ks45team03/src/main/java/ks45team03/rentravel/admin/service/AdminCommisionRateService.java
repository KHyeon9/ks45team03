package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.CommisionRate;
import ks45team03.rentravel.mapper.AdminCommisionRateMapper;

@Service
@Transactional
public class AdminCommisionRateService {

	private final AdminCommisionRateMapper adminCommisionRateMapper;
	
	public AdminCommisionRateService(AdminCommisionRateMapper adminCommisionRateMapper) {
		
		this.adminCommisionRateMapper = adminCommisionRateMapper;
	}
	
	
	/**
	 * 플랫폼 수수료율 추가
	 * @param commisionRate
	 */
	public void adminAddCommisionRate (CommisionRate commisionRate) {
		
		adminCommisionRateMapper.adminAddCommisionRate(commisionRate);
	}
	
	
	/**
	 * 플랫폼 수수료율 목록
	 * @return List<CommisionRate>
	 */
	public List<CommisionRate> adminGetCommisionRateList (){
		
		List<CommisionRate> adminGetCommisionRateList = adminCommisionRateMapper.adminGetCommisionRateList();
		
		return adminGetCommisionRateList;
	}
}
