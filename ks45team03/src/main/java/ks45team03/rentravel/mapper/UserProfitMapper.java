package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Payment;
import ks45team03.rentravel.dto.Profit;
import ks45team03.rentravel.dto.ProfitDay;
import ks45team03.rentravel.dto.ProfitMonth;
import ks45team03.rentravel.dto.ProfitYear;

@Mapper
public interface UserProfitMapper {
	
	// -----회원 연별 수익 추가 관련
	
	/* 회원 연별 수익 업데이트 */
	public void updateUserYearProfit(String loginId, String profitYear, int ownerProfitJanuary, int ownerProfitFebruary, int ownerProfitMarch, int ownerProfitApril
									,int ownerProfitMay, int ownerProfitJune, int ownerProfitJuly, int ownerProfitAugust, int ownerProfitSeptember, int ownerProfitOctober, int ownerProfitNovember
									,int ownerProfitDecember);
	
	/* 회원 연별 수익 처음 추가 */
	public void addFirstUserYearProfit (String profitYearCode, String loginId, String profitYear, int ownerProfitJanuary, int ownerProfitFebruary, int ownerProfitMarch, int ownerProfitApril
										,int ownerProfitMay, int ownerProfitJune, int ownerProfitJuly, int ownerProfitAugust, int ownerProfitSeptember, int ownerProfitOctober, int ownerProfitNovember
										,int ownerProfitDecember);
	
	/* 아이디별 월별 수익 확인 */
	public int getUserMonthProfit (String profitMonth, String loginId);
	
	/* getUserProfitYearCount */
	public int getUserProfitYearCount(String profitYear, String loginId);
	
	/* 일별 수익그룹코드 년도 조회 */
	public String getUserDayGroupCodeYear (String paymentCode);
	
	
	
	
	// -----회원 월별 수익 추가 관련
	
	/* 회원 월별 수익 업데이트 */
	public void updateUserMonthProfit(int userMonthProfitTotal, String monthGroupCode);
	
	/* 회원 월별 수익 처음 추가 */
	public void addFirstUserMonthProfit (String profitMonthCode, String loginId, String profitSaveYearMonth, String monthGroupCode, int settlementAmount);
	
	/* 해당 월별수익 그룹코드가 몇개인지 확인 */
	public int monthGroupCodeCount (String monthGroupCode);	
	
	/* 회원 월별 수익 총 금액 조회 */
	public int getUserMonthProfitTotal (int settlementAmount, String monthGroupCode);
	
	
	
	
	// -----회원 일별 수익 추가 관련
	
	/* 회원 일별 수익 업데이트 */
	public void updateUserDayProfit(int userDayProfitTotal, String dayGroupCode);
	
	/* 회원 일별 수익 처음 추가 */
	public void addFirstUserDayProfit (String profitDayCode, String loginId, String profitSaveYearMonth, int settlementAmount, String dayGroupCode, String monthGroupCode);
	
	/* 해당 일별수익 그룹코드가 몇개인지 확인 */
	public int dayGroupCodeCount (String dayGroupCode);
	
	/* 회원 일별 수익 총 금액 조회 */
	public int getUserDayProfitTotal (int settlementAmount, String dayGroupCode);
	
	
	
	// -----회원 수익 추가 관련
	
	/* 회원 수익 추가 */
	public void addtUserProfit(String profitCode, String loginId, String paymentCode, int settlementAmount, String profitSaveTime, String dayGroupCode);
	
	/* 회원 처음수익 추가 */
	public void addFirstUserProfit(String profitCode, String loginId, String paymentCode, int settlementAmount, int totalProfit, String profitSaveTime, String dayGroupCode);
	
	/* 해당 회원의 수익이 수익목록에 존재하는지 확인 */
	public int getProfitUserCount (String loginId);
	
	/* 회원 수익 총 금액 조회 */
	public int getUserProfitTotal (int settlementAmount, String loginId);
	
	/* 결제정보 목록 조회 */
	public Payment getUserPaymentInfo (String paymentCode);
	
	
	
	// -----회원 수익 그룹코드 관련
	
	/* 월별 수익 그룹코드 날짜 조회 */
	public String getUserMonthGroupCodeDate(String paymentCode);
	
	/* 일별 수익 그룹코드 날짜 조회 */
	public String getUserDayGroupCodeDate (String paymentCode);
	
	
	
	// -----회원 수익 목록
	
	/* 회원 연별 수익 목록 조회 */
	public List<ProfitYear> getUserYearProfitList (String loginId, int startIndex, int pageSize, String searchYear);
	
	/* 회원 월별 수익 목록 조회 */
	public List<ProfitMonth> getUserMonthProfitList (String loginId, int startIndex, int pageSize, String searchYear,String searchMonth);
	
	/* 회원 일별 수익 목록 조회 */
	public List<ProfitDay> getUserDayProfitList(String loginId, int startIndex, int pageSize, String searchYear,String searchMonth,String searchDay);

	/* 회원 수익 목록 조회 */
	public List<Profit> getUserProfitList (String loginId, int startIndex, int pageSize);
	
	/* 연별 회원 수익 목록 행 갯수 */
	public int YearProfitListCnt (String loginId, String searchYear);
	
	/* 월별 회원 수익 목록 행 갯수 */
	public int MonthProfitListCnt (String loginId,String searchYear, String searchMonth);
	
	/* 일별 회원 수익 목록 행 갯수 */
	public int dayProfitListCnt (String loginId,String searchYear, String searchMonth, String searchDay);
	
	/* 회원 수익 목록 행 갯수 */
	public int profitListCnt (String loginId);
}
