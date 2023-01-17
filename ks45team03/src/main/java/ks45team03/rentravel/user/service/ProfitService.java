package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.Payment;
import ks45team03.rentravel.dto.ProfitDay;
import ks45team03.rentravel.dto.ProfitYear;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.UserProfitMapper;

@Service
@Transactional
public class ProfitService {

	private final UserProfitMapper userProfitMapper;
	private final CommonNewCode commonNewCode;
	
	public ProfitService (UserProfitMapper userProfitMapper, CommonNewCode commonNewCode) {
		
		this.userProfitMapper = userProfitMapper;
		this.commonNewCode = commonNewCode;
	}
	
	/* 회원 연별 수익 추가 */
	public void addUserYearProfit (String profitSaveYearMonth, String paymentCode, String loginId) {
		
		String profitMonth = profitSaveYearMonth.substring(3,5);		
		String profitYear = userProfitMapper.getUserDayGroupCodeYear(paymentCode);
		int yearCount = userProfitMapper.getUserProfitYearCount(profitYear, loginId);
		
		String profitYearCode = commonNewCode.getCommonNewCode("tb_profit_year", "profit_year_code");
		
		int ownerProfitJanuary = 0;
		int ownerProfitFebruary = 0;
		int ownerProfitMarch = 0;
		int ownerProfitApril = 0;
		int ownerProfitMay = 0;
		int ownerProfitJune = 0;
		int ownerProfitJuly = 0;
		int ownerProfitAugust = 0;
		int ownerProfitSeptember = 0;
		int ownerProfitOctober = 0;
		int ownerProfitNovember = 0;
		int ownerProfitDecember = 0;		
				
		 if(yearCount < 1) {
			 
			 if(profitMonth.equals("01")) {
				 ownerProfitJanuary = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 				 
			 
			 }else if (profitMonth.equals("02")) {
				 ownerProfitFebruary = userProfitMapper.getUserMonthProfit(profitMonth, loginId);			 
				 
			 }else if (profitMonth.equals("03")) {
				 ownerProfitMarch = userProfitMapper.getUserMonthProfit(profitMonth, loginId);			 
				 
			 }else if (profitMonth.equals("04")) {
				 ownerProfitApril = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }else if (profitMonth.equals("05")) {
				 ownerProfitMay = userProfitMapper.getUserMonthProfit(profitMonth, loginId);
								 
			 }else if (profitMonth.equals("06")) {
				 ownerProfitJune = userProfitMapper.getUserMonthProfit(profitMonth, loginId);			 
				 
			 }else if (profitMonth.equals("07")) {
				 ownerProfitJuly = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }else if (profitMonth.equals("08")) {
				 ownerProfitAugust = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }else if (profitMonth.equals("09")) {
				 ownerProfitSeptember = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				
				 
			 }else if (profitMonth.equals("10")) {
				 ownerProfitOctober = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }else if (profitMonth.equals("11")) {
				 ownerProfitNovember = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }else if (profitMonth.equals("12")) {
				 ownerProfitDecember = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }
			 
			 userProfitMapper.addFirstUserYearProfit(profitYearCode, loginId, profitYear, ownerProfitJanuary, ownerProfitFebruary, ownerProfitMarch, 
						ownerProfitApril, ownerProfitMay, ownerProfitJune, ownerProfitJuly, ownerProfitAugust, ownerProfitSeptember, 
						ownerProfitOctober, ownerProfitNovember, ownerProfitDecember);		 
		 }else {
			 
			 if(profitMonth.equals("01")) {
				 ownerProfitJanuary = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 				 
			 
			 }else if (profitMonth.equals("02")) {
				 ownerProfitFebruary = userProfitMapper.getUserMonthProfit(profitMonth, loginId);			 
				 
			 }else if (profitMonth.equals("03")) {
				 ownerProfitMarch = userProfitMapper.getUserMonthProfit(profitMonth, loginId);			 
				 
			 }else if (profitMonth.equals("04")) {
				 ownerProfitApril = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }else if (profitMonth.equals("05")) {
				 ownerProfitMay = userProfitMapper.getUserMonthProfit(profitMonth, loginId);
								 
			 }else if (profitMonth.equals("06")) {
				 ownerProfitJune = userProfitMapper.getUserMonthProfit(profitMonth, loginId);			 
				 
			 }else if (profitMonth.equals("07")) {
				 ownerProfitJuly = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }else if (profitMonth.equals("08")) {
				 ownerProfitAugust = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }else if (profitMonth.equals("09")) {
				 ownerProfitSeptember = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				
				 
			 }else if (profitMonth.equals("10")) {
				 ownerProfitOctober = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }else if (profitMonth.equals("11")) {
				 ownerProfitNovember = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }else if (profitMonth.equals("12")) {
				 ownerProfitDecember = userProfitMapper.getUserMonthProfit(profitMonth, loginId);				 
				 
			 }
			 
			 userProfitMapper.updateUserYearProfit(loginId, profitYear, ownerProfitJanuary, ownerProfitFebruary, ownerProfitMarch, 
					 								ownerProfitApril, ownerProfitMay, ownerProfitJune, ownerProfitJuly, ownerProfitAugust, ownerProfitSeptember, 
					 								ownerProfitOctober, ownerProfitNovember, ownerProfitDecember);
			 
		 }
		
	}
	
	
	
	
	/* 회원 월별 수익 추가 */
	public void addUserMonthProfit (String monthGroupCode, String loginId, int settlementAmount, String profitSaveYearMonth) {
		
		int monthGroupCodeCount = userProfitMapper.monthGroupCodeCount(monthGroupCode);
		String profitMonthCode = commonNewCode.getCommonNewCode("tb_profit_month", "profit_month_code");
		
		if(monthGroupCodeCount < 1) {
			userProfitMapper.addFirstUserMonthProfit(profitMonthCode, loginId, profitSaveYearMonth, monthGroupCode, settlementAmount);
		}else {
			int userMonthProfitTotal =  userProfitMapper.getUserMonthProfitTotal(settlementAmount, monthGroupCode);
			userProfitMapper.updateUserMonthProfit(userMonthProfitTotal, monthGroupCode);
			
		} 
	}
	
	
	
	
	/* 회원 일별 수익 추가 */
	public void addUserDayProfit (String dayGroupCode, String loginId, int settlementAmount, String profitSaveYearMonth, String monthGroupCode) {
		
		int dayGroupCodeCount = userProfitMapper.dayGroupCodeCount(dayGroupCode);
		String profitDayCode = commonNewCode.getCommonNewCode("tb_profit_day", "profit_day_code");		
		
		if(dayGroupCodeCount < 1) {
			userProfitMapper.addFirstUserDayProfit(profitDayCode, loginId, profitSaveYearMonth, settlementAmount, dayGroupCode, monthGroupCode);			
		}else {
			int userDayProfitTotal = userProfitMapper.getUserDayProfitTotal(settlementAmount, dayGroupCode);
			
			userProfitMapper.updateUserDayProfit(userDayProfitTotal, dayGroupCode);
		}
		
	}
	
	
	/* 회원 수익 추가 */
	public void addUserProfit (String paymentCode, String loginId, int settlementAmount, String dayGroupCode) {
		
		Payment UserPaymentInfo = userProfitMapper.getUserPaymentInfo(paymentCode);		
		String profitCode = commonNewCode.getCommonNewCode("tb_profit", "profit_code");		
		String profitSaveTime = UserPaymentInfo.getPaymentTime();
		
		int userCount = userProfitMapper.getProfitUserCount(loginId);
		
		if(userCount < 1) {
			userProfitMapper.addtUserProfit(profitCode, loginId, paymentCode, settlementAmount, profitSaveTime, dayGroupCode);
		}else {		
			int totalProfit = userProfitMapper.getUserProfitTotal(settlementAmount, loginId);
			userProfitMapper.addFirstUserProfit(profitCode, loginId, paymentCode, settlementAmount, totalProfit, profitSaveTime, dayGroupCode);	
		}
	}
	
	
	/* 정삼금 획득 년월 */
	public String getProfitSaveYearMonth (String MonthGroupCode) {
		String profitSaveYearMonth =  MonthGroupCode.substring(10, 12) + "년"+ MonthGroupCode.substring(12,14) + "월";
		
		return profitSaveYearMonth;
		
	}
	
	
	/* 수익 월별 그룹 코드 */
	public String getUserMonthGroupCode (String paymentCode, String loginId) {
		
		String MonthGroupCodeDate = userProfitMapper.getUserMonthGroupCodeDate(paymentCode);
		String MonthGroupCode = loginId + "월별수익_" +  MonthGroupCodeDate;
		
		return MonthGroupCode;
		
	}
	
	
	/* 수익 일별 그룹 코드 */
	public String getUserDayGroupCode (String paymentCode, String loginId) {
		
		String DayGroupCodeDate = userProfitMapper.getUserDayGroupCodeDate(paymentCode);
		String dayGroupCode = loginId + "일별수익_" + DayGroupCodeDate;
		
		
		return dayGroupCode;
	}
	
	
	/* 수익 일별 목록 검색시 일 의 길이가 1일때*/
	public List<ProfitDay> getUserDayProfitList(String loginId, int startIndex, int pageSize, String searchYear,String searchMonth,String searchDay) {
			
		if(searchDay.length() == 1) {
			
			searchDay = "0" + searchDay;
		}
		
		List<ProfitDay> getUserYearProfitList = userProfitMapper.getUserDayProfitList(loginId, startIndex, pageSize, searchYear, searchMonth, searchDay);
		
		return getUserYearProfitList;
	}
	
	
}
