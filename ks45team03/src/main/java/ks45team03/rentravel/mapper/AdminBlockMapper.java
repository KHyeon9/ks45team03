package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Block;

@Mapper
public interface AdminBlockMapper {
	
	
	
	/* 회원 차단 목록 행 갯수 */
	public int getBlockListCnt(String searchKey, String searchValue);
	
	/* 회원 차단 목록 조회 */
	public List<Block>adminGetUserBlockList (int startIndex, int pageSize, String searchKey, String searchValue);
	
	
}
