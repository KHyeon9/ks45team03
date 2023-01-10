package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Profit;
import ks45team03.rentravel.dto.ProfitDay;

@Mapper
public interface UserProfitMapper {
	
	/* 회원 일별 수익 목록 조회 */
	public List<ProfitDay> getUserDayProfitList(String loginId, int startIndex, int pageSize, String searchYear,String searchMonth,String searchDay, String profitDayGroup);

	/* 회원 수익 목록 조회 */
	public List<Profit> getUserProfitList (String loginId, int startIndex, int pageSize);
	
	/* 일별 회원 수익 목록 행 갯수 */
	public int dayProfitListCnt (String loginId);
	
	/* 회원 수익 목록 행 갯수 */
	public int profitListCnt (String loginId);
}
