package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.ProfitDay;
import ks45team03.rentravel.mapper.UserProfitMapper;

@Service
@Transactional
public class ProfitService {

	private final UserProfitMapper userProfitMapper;
	
	public ProfitService (UserProfitMapper userProfitMapper) {
		
		this.userProfitMapper = userProfitMapper;
	}
	
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
