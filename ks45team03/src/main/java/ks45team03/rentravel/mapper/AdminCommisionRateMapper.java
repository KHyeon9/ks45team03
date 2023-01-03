package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.CommisionRate;

@Mapper
public interface AdminCommisionRateMapper {
	

	
	//플랫폼 수수료율 수정
	public int adminModifyCommisionRate (CommisionRate commisionRate);
	
	//특정 플랫폼 수수료율 조회 
	public CommisionRate adminGetCommisionRateListByCode (String commisionRateCode);
	
	//플랫폼 수수료율 추가
	public int adminAddCommisionRate (CommisionRate commisionRate);
	
	// 플랫폼 수수료율 목록 행 갯수 
	public int getCommisionRateListCnt();
	
	//플랫폼 수수료율 목록 조회
	public List<CommisionRate> adminGetCommisionRateList(Map<String, Object> paramMap);
	
	
}
