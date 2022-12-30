package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Insurance;

@Mapper
public interface InsuranceMapper {
	// 보험가입리스트 조회
	public List<Insurance> adminGetInsuranceList();
	
	// 보상금신청서(상세화면) 조회
	
	
}