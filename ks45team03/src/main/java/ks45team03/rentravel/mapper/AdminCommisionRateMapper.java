package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.CommisionRate;

@Mapper
public interface AdminCommisionRateMapper {
	
	
	//플랫폼 수수료율 추가
	public int adminAddCommisionRate (CommisionRate commisionRate);
	
	//플랫폼 수수료율 목록 조회
	public List<CommisionRate> adminGetCommisionRateList();
	
	
}
