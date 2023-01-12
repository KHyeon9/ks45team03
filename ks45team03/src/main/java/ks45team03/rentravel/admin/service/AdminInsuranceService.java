package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsurancePayout;
import ks45team03.rentravel.mapper.AdminInsuranceMapper;


@Service
public class AdminInsuranceService {
	
	private final AdminInsuranceMapper adminInsuranceMapper;
	
	public AdminInsuranceService(AdminInsuranceMapper adminInsuranceMapper) {
		this.adminInsuranceMapper = adminInsuranceMapper;
	}
	
	/**
	 * 보험 수정(보험이용가능 여부 갱신)
	 * @return int
	 */
	public int adminModifyInsurance() {
		
		return adminInsuranceMapper.adminModifyInsurance();
	}
	
	
	/**
	 * 보상금청구서 등록
	 * @return int
	 */
	public int adminAddInsuranceBillDetail() {
		
		return adminInsuranceMapper.adminAddInsuranceBillDetail();
	}
	
	/**
	 * 보상금청구서 수정
	 * @return int
	 */
	public int adminModifyInsuranceBillDetail() {
		
		return adminInsuranceMapper.adminModifyInsuranceBillDetail();
	}
	
	/**
	 * 보상금청구서 삭제
	 */
	public void adminRemoveInsuranceBillDetail() {
		
		adminInsuranceMapper.adminRemoveInsuranceBillDetail();
	}
	
	/**
	 * 보상금청구상태 갱신
	 * @return int
	 */
	
	public int adminModifyInsuranceBillState() {
		
		return adminInsuranceMapper.adminModifyInsuranceBillState();
	}
	
	
}
