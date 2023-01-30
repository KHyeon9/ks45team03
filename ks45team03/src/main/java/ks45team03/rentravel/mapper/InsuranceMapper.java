package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsurancePayout;

@Mapper
public interface InsuranceMapper {
	
	// 나의 보험 정보 조회(로그인아이디)
	public List<Insurance> getInsuranceInfoById(String loginId);
	
	// 보험금청구서 작성 - 인적사항조회(로그인아이디 + 보험코드)
	public List<Insurance> getInsuranceUser(String loginId, String insuranceCode);
	
	// 나의 보험 정보 조회(보험코드)
	public List<Insurance> getInsuranceInfo(String insuranceCode);
	
	// 보험코드로 보상금접수증 존재여부 판단
	public String justifyInsuranceBillRecipt(String insuranceCode);
	
	//보상금 접수증 리스트(보험코드)
	public List<InsuranceBillDetail> getInsuranceBillReciptInfoById(String insuranceCode);
	
	// 보상금접수증 리스트(보상금접수증코드)
	public List<InsuranceBillDetail> getInsuranceBillDetailInfoById(String insuranceBillDetailCode);

	// 나의 보상금청구서 조회(로그인아이디)
	public List<InsuranceBill> getInsuranceBillInfoById(String loginId);
	
	// 보상금접수증 등록
	public int addInsuranceBillDetail(InsuranceBillDetail insuranceBillDetail);
	
	// 보상금접수증 수정
	public int modifyInsuranceBillDetail(InsuranceBillDetail insuranceBillDetail);
	
	// 보상금접수증 삭제
	public void removeInsuranceBillDetail(String insuranceBillDetailCode);
	
	// 나의 보상금지급내역 조회
	public List<InsurancePayout> getInsurancePayoutInfoById(String loginId);
	
}