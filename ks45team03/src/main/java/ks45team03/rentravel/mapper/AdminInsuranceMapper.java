package ks45team03.rentravel.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceClaim;
import ks45team03.rentravel.dto.InsurancePayout;
import ks45team03.rentravel.dto.InsuranceRequest;

@Mapper
public interface AdminInsuranceMapper {
	
	// 모든 회원 보험가입리스트 조회
	public List<Insurance> adminGetInsuranceList();
	
	// 보험가입
	public int adminAddInsurance(Insurance insurance);
	
	// 보험코드로 보험삭제
	public void adminRemoveInsuranceByCode(String insuranceCode);
	
	// 보상금신청서(상세화면) 조회
	public List<InsuranceRequest> adminGetInsuranceRequestList();
	
	// 보상금청구상태 조회
	public List<InsuranceClaim> adminGetInsuranceClaimList();
		
	// 보상금청구상태 갱신
	public int adminModifyInsuranceRequestState(InsuranceRequest insuranceRequest);
	
	// 보상금 지급내역 조회
	public List<InsurancePayout> adminGetInsurancePayoutList();
	
	// 보상금 지급내역 등록
	public int adminAddInsurancePayout(InsurancePayout insurancePayout);
	
}
