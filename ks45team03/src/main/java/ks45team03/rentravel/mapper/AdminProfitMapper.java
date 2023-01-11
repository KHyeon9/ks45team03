package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Profit;
import ks45team03.rentravel.dto.ProfitMonth;
import ks45team03.rentravel.dto.ProfitYear;

@Mapper
public interface AdminProfitMapper {
	
	/* 회원 연별 수익 목록 조회 */
	public List<ProfitYear> adminGetUserYearProfitList (int startIndex, int pageSize, String searchYear, String searchId);
	
	/* 회원 월별 수익 목록 조회 */
	public List<ProfitMonth> adminGetUserMonthProfitList (int startIndex, int pageSize, String searchYear,String searchMonth, String searchId);
	
	/* 회원 일별 수익 목록 조회 */
	public List<Profit> adminGetUserDayProfitList (int startIndex, int pageSize,String searchYear,String searchMonth,String searchDay, String searchId);
	
	/* 회원 수익 목록 조회 */
	public List<Profit> adminGetUserProfitList (int startIndex, int pageSize, String searchId);
	
	/* 회원 연별 수익 목록 행 갯수 */
	public int yearProfitListCnt();
	
	/* 회원 월별 수익 목록 행 갯수 */
	public int monthProfitListCnt();
	
	/* 회원 일별 수익 목록 행 갯수 */
	public int dayProfitListCnt ();
	
	/* 회원 수익 목록 행 갯수 */
	public int profitListCnt ();
}
