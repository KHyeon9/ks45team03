package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceClaim;
import ks45team03.rentravel.dto.InsurancePayout;
import ks45team03.rentravel.dto.InsuranceRequest;
import ks45team03.rentravel.mapper.AdminInsuranceMapper;

@Service
@Transactional
public class AdminInsuranceService {
	
	private final AdminInsuranceMapper adminInsuranceMapper;
	
	public AdminInsuranceService(AdminInsuranceMapper adminInsuranceMapper) {
		this.adminInsuranceMapper = adminInsuranceMapper;
	}
	
	/**
	 * 모든 회원 보험가입정보 조회
	 * @return List<Insurance>
	 */
	public List<Insurance> adminGetInsuranceList() {
		List<Insurance> adminInsuranceList = adminInsuranceMapper.adminGetInsuranceList();
		
		return adminInsuranceList;
	}
	
	/**
	 * 보험 가입
	 * @param insurance
	 * @return int
	 */
	public int adminAddInsurance(Insurance insurance) {
		
		return adminInsuranceMapper.adminAddInsurance(insurance);
	}
	
	/**
	 * 보험코드로 보험삭제
	 * @param insuranceCode
	 */
	public void adminRemoveInsuranceByCode(String insuranceCode) {
		
		adminInsuranceMapper.adminRemoveInsuranceByCode(insuranceCode);
	}
	
	/**
	 * 보상금신청서 조회(보상금청구서 상세화면)
	 * @return List<InsuranceRequest>
	 */
	public List<InsuranceRequest> adminGetInsuranceRequestList() {
		List<InsuranceRequest> adminInsuranceRequestList = adminInsuranceMapper.adminGetInsuranceRequestList();
		
		return adminInsuranceRequestList;
	}
	
	/**
	 * 모든 회원 보상금청구상태 조회(보상금청구서리스트)
	 * @return List<InsuranceClaim>
	 */
	public List<InsuranceClaim> adminGetInsuranceClaimList() {
		List<InsuranceClaim> adminInsuranceClaimList = adminInsuranceMapper.adminGetInsuranceClaimList();
		
		return adminInsuranceClaimList;
	}
	
	/**
	 * 보상금 청구상태 갱신
	 * @param insuranceRequest
	 * @return int
	 */
	public int adminModifyInsuranceRequestState(InsuranceRequest insuranceRequest) {
		
		return adminInsuranceMapper.adminModifyInsuranceRequestState(insuranceRequest);
	}
	
	/**
	 * 모든 회원 보상금 지급내역 조회
	 * @return List<InsurancePayout>
	 */
	public List<InsurancePayout> adminGetInsurancePayoutList() {
		List<InsurancePayout> adminInsurancePayoutList = adminInsuranceMapper.adminGetInsurancePayoutList();
		
		return adminInsurancePayoutList;
	}
	
	/**
	 * 보상금 지급내역 등록
	 * @param insurancePayout
	 * @return
	 */
	public int adminAddInsurancePayout(InsurancePayout insurancePayout) {
		return adminInsuranceMapper.adminAddInsurancePayout(insurancePayout);
	}
}
