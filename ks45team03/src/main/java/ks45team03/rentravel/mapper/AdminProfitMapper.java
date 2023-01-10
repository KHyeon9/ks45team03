package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Profit;

@Mapper
public interface AdminProfitMapper {
	
	/* 회원 일별 수익 목록 조회 */
	public List<Profit> adminGetUserDayProfitList (int startIndex, int pageSize, String profitDayGroup, String searchYear,String searchMonth,String searchDay, String searchId , String userId);
	
	/* 회원 수익 목록 조회 */
	public List<Profit> adminGetUserProfitList (int startIndex, int pageSize, String searchId , String userId);
	
	/* 회원 일별 수익 목록 행 갯수 */
	public int dayProfitListCnt ();
	
	/* 회원 수익 목록 행 갯수 */
	public int profitListCnt ();
}
