package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.Payment;
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
	
	
	/* 회원 일별 수익 추가 */
	public void addUserDayProfit (String dayGroupCode, String loginId, int settlementAmount, String profitSaveYearMonth, String MonthGroupCode) {
		
		int dayGroupCodeCount = userProfitMapper.dayGroupCodeCount(dayGroupCode);
		String profitDayCode = commonNewCode.getCommonNewCode("tb_profit_day", "profit_day_code");		
		
		if(dayGroupCodeCount < 1) {
			userProfitMapper.addFirstUserDayProfit(profitDayCode, loginId, profitSaveYearMonth, settlementAmount, dayGroupCode, MonthGroupCode);			
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
	
	
}
