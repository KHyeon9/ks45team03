package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Profit;
import ks45team03.rentravel.dto.ProfitDay;
import ks45team03.rentravel.dto.ProfitMonth;
import ks45team03.rentravel.dto.ProfitYear;

@Mapper
public interface UserProfitMapper {
	
	/* 회원 연별 수익 목록 조회 */
	public List<ProfitYear> getUserYearProfitList (String loginId, int startIndex, int pageSize, String searchYear, String ownerProfitYear);
	
	/* 회원 월별 수익 목록 조회 */
	public List<ProfitMonth> getUserMonthProfitList (String loginId, int startIndex, int pageSize, String searchYear,String searchMonth,String profitMonthGroup);
	
	/* 회원 일별 수익 목록 조회 */
	public List<ProfitDay> getUserDayProfitList(String loginId, int startIndex, int pageSize, String searchYear,String searchMonth,String searchDay, String profitDayGroup);

	/* 회원 수익 목록 조회 */
	public List<Profit> getUserProfitList (String loginId, int startIndex, int pageSize);
	
	/* 연별 회원 수익 목록 행 갯수 */
	public int YearProfitListCnt (String loginId);
	
	/* 월별 회원 수익 목록 행 갯수 */
	public int MonthProfitListCnt (String loginId);
	
	/* 일별 회원 수익 목록 행 갯수 */
	public int dayProfitListCnt (String loginId);
	
	/* 회원 수익 목록 행 갯수 */
	public int profitListCnt (String loginId);
}
