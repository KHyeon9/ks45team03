package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsurancePayout;

@Mapper
public interface InsuranceMapper {
	
	// 나의 보험 정보 조회
	public List<Insurance> getInsuranceInfoById(String loginId);
	
	// 보험정보 카운트
	public Integer countInsurance(String loginId);
	
	// 보상금청구서 카운트
	public Integer countInsuranceBill(String loginId);
	
	// 보상금지급내역 카운트
	public Integer countInsurancePayout(String loginId);
	
	//보상금 접수증
	public List<InsuranceBillDetail> getInsuranceBillReciptInfoById(String insuranceCode);
	
	// 보상금청구서 상세화면
	public List<InsuranceBillDetail> getInsuranceBillDetailInfoById(String insuranceBillDetailCode);
	
	// 나의 보상금청구서 조회
	public List<InsuranceBill> getInsuranceBillInfoById(String loginId);
	
	// 보상금청구서 등록
	public int addInsuranceBillDetail(String insuranceCode);
	
	// 보상금청구서 수정
	public int modifyInsuranceBillDetail(InsuranceBillDetail insuranceBillDetail);
	
	// 보상금청구서 삭제
	public void removeInsuranceBillDetail();
	
	// 나의 보상금지급내역 조회
	public List<InsurancePayout> getInsurancePayoutInfoById(String loginId);
	
}