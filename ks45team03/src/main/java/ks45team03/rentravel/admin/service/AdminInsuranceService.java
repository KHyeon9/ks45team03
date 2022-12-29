package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.mapper.AdminInsuranceMapper;

@Service
@Transactional
public class AdminInsuranceService {
	
	private final AdminInsuranceMapper adminInsuranceMapper;
	
	public AdminInsuranceService(AdminInsuranceMapper adminInsuranceMapper) {
		this.adminInsuranceMapper = adminInsuranceMapper;
	}
	
	public List<Insurance> adminGetInsuranceList() {
		List<Insurance> insuranceList = adminInsuranceMapper.adminGetInsuranceList();
		
		return insuranceList;
	}

}
