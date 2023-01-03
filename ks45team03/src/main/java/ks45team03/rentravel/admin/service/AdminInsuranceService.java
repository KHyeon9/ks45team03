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
	 * 보험 조회
	 * @return List<Insurance>
	 */
	public List<Insurance> adminGetInsuranceList() {
		
		List<Insurance> adminInsuranceList = adminInsuranceMapper.adminGetInsuranceList();
		
		return adminInsuranceList;
	}
	/**
	 * 보험 등록
	 * @return int
	 */
	public int adminAddInsurance() {
		
		return adminInsuranceMapper.adminAddInsurance();
	}
	
	/**
	 * 보험 삭제
	 */
	public void adminRemoveInsurance() {
		
		adminInsuranceMapper.adminRemoveInsurance();
	}
	
	
	/**
	 * 보상금청구서 조회
	 * @return List<InsuranceBill>
	 */
	public List<InsuranceBill> adminGetInsuranceBillList() {
		List<InsuranceBill> adminInsuranceBillList = adminInsuranceMapper.adminGetInsuranceBillList();
		
		return adminInsuranceBillList;
		
	}
	
	/**
	 * 보상금청구서 상세화면
	 * @return List<InsuranceBillDetail>
	 */
	public  List<InsuranceBillDetail> adminGetInsuranceBillDetail() {
		List<InsuranceBillDetail> adminInsuranceBillDetail = adminInsuranceMapper.adminGetInsuranceBillDetail();
		
		return adminInsuranceBillDetail;
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
	
	/**
	 * 보상금지급내역
	 * @return List<InsurancePayout>
	 */
	public List<InsurancePayout> adminGetInsurancePayoutList() {
		
		List<InsurancePayout> adminInsurancePayout = adminInsuranceMapper.adminGetInsurancePayoutList();
		
		return adminInsurancePayout;
	}
	
	public int adminAddInsurancePayoutList() {
		
		return adminInsuranceMapper.adminAddInsurancePayoutList();
	}
	
}
