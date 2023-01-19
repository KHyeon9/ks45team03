package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsuranceBillState;
import ks45team03.rentravel.dto.InsurancePayout;

@Mapper
public interface AdminInsuranceMapper {
	
	// 보험가입리스트 조회
	public List<Insurance> adminGetInsuranceList();
	
	// 보험 수정(보험이용가능 여부 갱신)
	public int adminModifyInsurance();
	
	// 보상금청구서리스트
	public List<InsuranceBill> adminGetInsuranceBillList();
	
	//보상금청구상태리스트
	public List<InsuranceBillState> adminGetInsuranceBillStateList();
	
	// 보상금청구서 상세화면
	public List<InsuranceBillDetail> adminGetInsuranceBillDetail();
	
	// 보상금지급내역
	public List<InsurancePayout> adminGetInsurancePayoutList();
	
	// 보상금지급내역 등록
	public int adminAddInsurancePayout(InsurancePayout insurancePayout);
	
	// 보상금지급내역 수정
	public int adminModifyInsurancePayout();
		
	// 보상금지급내역 삭제
	public int adminRemoveInsurancePayout();
}