package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.Profit;
import ks45team03.rentravel.mapper.AdminProfitMapper;

@Service
@Transactional
public class AdminProfitService {

	private final AdminProfitMapper adminProfitMapper;
	
	public AdminProfitService (AdminProfitMapper adminProfitMapper) {
		
		this.adminProfitMapper = adminProfitMapper;
	}
	
	
	public List<Profit> adminGetUserDayProfitList (int startIndex, int pageSize, String profitDayGroup, String searchYear,String searchMonth,String searchDay, String searchId , String userId){
		
		switch (userId) {
		case "userId":
			userId = "pd.user_id";
			break;
		}
		
		switch (profitDayGroup) {
		case "profitDayGroup":
			profitDayGroup = "pd.profit_day_group";
			break;
		}
		
		List <Profit> adminGetUserDayProfitList = adminProfitMapper.adminGetUserDayProfitList(startIndex, pageSize, profitDayGroup, searchYear, searchMonth, searchDay, searchId, userId);
		
		return adminGetUserDayProfitList;
		
	}
	
	
	/* 회원 수익 목록 조회 */
	public List<Profit> adminGetUserProfitList (int startIndex, int pageSize, String searchId , String userId){
		
		switch (userId) {
		case "userId":
			userId = "p.user_id";
			break;

		}
		
		List <Profit> adminGetUserProfitList = adminProfitMapper.adminGetUserProfitList(startIndex, pageSize, searchId, userId);
		
		return adminGetUserProfitList;
	}
}
