package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsurancePayout;

@Mapper
public interface InsuranceMapper {
	// 보험가입리스트 조회
	public List<Insurance> adminGetInsuranceList();
	
	// 보험청구서리스트
	public List<InsuranceBill> getInsuranceBillList();
	
	// 보상금청구서 상세화면
	public List<InsuranceBillDetail> getInsuranceBillDetail();
	
	// 보상금청구서 등록
	public int addInsuranceBillDetail();
	
	// 보상금청구서 수정
	public int modifyInsuranceBillDetail();
	
	// 보상금청구서 삭제
	public void removeInsuranceBillDetail();
	
	// 보상금지급내역
	public List<InsurancePayout> getInsurancePayoutList();
	
}