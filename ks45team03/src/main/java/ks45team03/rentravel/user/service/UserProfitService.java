package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.ProfitDay;
import ks45team03.rentravel.dto.ProfitMonth;
import ks45team03.rentravel.dto.ProfitYear;
import ks45team03.rentravel.mapper.UserProfitMapper;

@Service
@Transactional
public class UserProfitService {

	private final UserProfitMapper userProfitMapper;
	
	public UserProfitService (UserProfitMapper userProfitMapper) {
		
		this.userProfitMapper = userProfitMapper;
	}
	
	
	public List<ProfitYear> getUserYearProfitList (String loginId, int startIndex, int pageSize, String searchYear, String ownerProfitYear){
		
		switch (ownerProfitYear) {
		case "ownerProfitYear":
			ownerProfitYear = "py.owner_profit_year";
			break;

		}
		
		List<ProfitYear> getUserYearProfitList =  userProfitMapper.getUserYearProfitList(loginId, startIndex, pageSize, searchYear, ownerProfitYear);
		
		return getUserYearProfitList;
		
	}
	
	/* 회원 월별 수익 목록 조회 */
	public List<ProfitMonth> getUserMonthProfitList (String loginId, int startIndex, int pageSize, String searchYear,String searchMonth,String profitMonthGroup){
		
		switch (profitMonthGroup) {
		case "profitMonthGroup":
			profitMonthGroup = "pm.profit_month_group";
			break;

		}
		
		List<ProfitMonth> getUserMonthProfitList = userProfitMapper.getUserMonthProfitList(loginId, startIndex, pageSize, searchYear, searchMonth, profitMonthGroup);
		
		return getUserMonthProfitList;
		
	}
	
	
	/* 회원 일별 수익 목록 조회 */
	public List<ProfitDay> getUserDayProfitList (String loginId, int startIndex, int pageSize, String searchYear,String searchMonth,String searchDay, String profitDayGroup){
		
		switch (profitDayGroup) {
		case "profitDayGroup":
			profitDayGroup = "pd.profit_day_group";
			break;

		}
		
		List<ProfitDay> getUserDayProfitList = userProfitMapper.getUserDayProfitList(loginId, startIndex, pageSize, searchYear, searchMonth, searchDay, profitDayGroup);
		
		return getUserDayProfitList;
		
	}
}
