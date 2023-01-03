package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsurancePayout;
import ks45team03.rentravel.mapper.InsuranceMapper;


@Service
public class InsuranceService {
	
	private final InsuranceMapper insuranceMapper;
	
	public InsuranceService(InsuranceMapper insuranceMapper) {
		this.insuranceMapper = insuranceMapper;
	}
	
	/**
	 * 보험 조회
	 * @return List<Insurance>
	 */
	public List<Insurance> getInsuranceList() {
		
		List<Insurance> insuranceList = insuranceMapper.getInsuranceList();
		
		return insuranceList;
	}
	
	/**
	 * 보상금청구서 조회
	 * @return List<InsuranceBill>
	 */
	public List<InsuranceBill> getInsuranceBillList() {
		List<InsuranceBill> insuranceBillList = insuranceMapper.getInsuranceBillList();
		
		return insuranceBillList;
		
	}
	
	/**
	 * 보상금청구서 상세화면
	 * @return List<InsuranceBillDetail>
	 */
	public  List<InsuranceBillDetail> getInsuranceBillDetail() {
		List<InsuranceBillDetail> insuranceBillDetail = insuranceMapper.getInsuranceBillDetail();
		
		return insuranceBillDetail;
	}
	
	/**
	 * 보상금청구서 등록
	 * @return int
	 */
	public int addInsuranceBillDetail() {
		
		return insuranceMapper.addInsuranceBillDetail();
	}
	
	/**
	 * 보상금청구서 수정
	 * @return int
	 */
	public int modifyInsuranceBillDetail() {
		
		return insuranceMapper.modifyInsuranceBillDetail();
	}
	
	/**
	 * 보상금청구서 삭제
	 */
	public void removeInsuranceBillDetail() {
		
		insuranceMapper.removeInsuranceBillDetail();
	}
	
	/**
	 * 보상금지급내역
	 * @return List<InsurancePayout>
	 */
	public List<InsurancePayout> getInsurancePayoutList() {
		
		List<InsurancePayout> insurancePayout = insuranceMapper.getInsurancePayoutList();
		
		return insurancePayout;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
