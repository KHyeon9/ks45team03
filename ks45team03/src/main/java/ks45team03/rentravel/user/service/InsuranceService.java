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
	 * 보상금청구서 수정
	 * @param insuranceBillDetail
	 * @return int(update 쿼리 실행 결과)
	 */
	public int modifyInsuranceBillDetail(InsuranceBillDetail insuranceBillDetail) {
		
		return insuranceMapper.modifyInsuranceBillDetail(insuranceBillDetail);
	}
	
	/**
	 * 보상금청구서 삭제
	 */
	public void removeInsuranceBillDetail() {
		
		insuranceMapper.removeInsuranceBillDetail();
	}
	
}
