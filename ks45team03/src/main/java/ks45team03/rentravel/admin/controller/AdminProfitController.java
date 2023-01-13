package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.Profit;
import ks45team03.rentravel.dto.ProfitMonth;
import ks45team03.rentravel.dto.ProfitYear;
import ks45team03.rentravel.mapper.AdminProfitMapper;

@Controller
@RequestMapping("/admin/profit")
public class AdminProfitController {
	
	private final AdminProfitMapper adminProfitMapper;
	
	public AdminProfitController (AdminProfitMapper adminProfitMapper) {
		
		this.adminProfitMapper = adminProfitMapper;
		
	}
	
	
	@GetMapping("/adminProfitList")
	public String adminGetUserProfitList (Model model
											,@RequestParam(defaultValue="1", required=false) int curPage
											,@RequestParam(value="userId", required = false, defaultValue = "") String userId
											,@RequestParam(value="searchId", required = false, defaultValue = "") String searchId) {
		
		int listCnt = adminProfitMapper.profitListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		
		List<Profit> adminGetUserProfitList =  adminProfitMapper.adminGetUserProfitList(pagination.getStartIndex(), pagination.getPageSize(), searchId);
		
		
		model.addAttribute("title","회원 수익 목록(조회)");
		model.addAttribute("adminGetUserProfitList",adminGetUserProfitList);
		model.addAttribute("pagination",pagination);
		
		return "/admin/profit/adminProfitList";
	}
	
	
	@GetMapping("/adminProfitListDay")	
	public String adminGetUserProfitListDay (Model model
											,@RequestParam(defaultValue="1", required=false) int curPage										
											,@RequestParam(value="searchYear", required = false, defaultValue = "") String searchYear
											,@RequestParam(value="searchMonth", required = false, defaultValue = "") String searchMonth
											,@RequestParam(value="searchDay", required = false, defaultValue = "") String searchDay										
											,@RequestParam(value="searchId", required = false, defaultValue = "") String searchId) {
		
		int listCnt = adminProfitMapper.dayProfitListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		
		List<Profit> adminGetUserDayProfitList = adminProfitMapper.adminGetUserDayProfitList(pagination.getStartIndex(), pagination.getPageSize(), searchYear, searchMonth, searchDay, searchId);
		
		model.addAttribute("title","회원 일별 수익 목록(조회)");
		model.addAttribute("adminGetUserDayProfitList",adminGetUserDayProfitList);
		model.addAttribute("pagination",pagination);
		
		return "/admin/profit/adminProfitListDay";
	}
	
	
	@GetMapping("/adminProfitListMonth")	
	public String adminGetUserProfitListMonth (Model model
												,@RequestParam(defaultValue="1", required=false) int curPage												
												,@RequestParam(value="searchYear", required = false, defaultValue = "") String searchYear
												,@RequestParam(value="searchMonth", required = false, defaultValue = "") String searchMonth
												,@RequestParam(value="searchId", required = false, defaultValue = "") String searchId) {
		
		int listCnt = adminProfitMapper.monthProfitListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		
		List<ProfitMonth> adminGetUserMonthProfitList = adminProfitMapper.adminGetUserMonthProfitList(pagination.getStartIndex(), pagination.getPageSize(), searchYear, searchMonth, searchId);
		
		model.addAttribute("title","회원 월별 수익 목록(조회)");
		model.addAttribute("adminGetUserMonthProfitList",adminGetUserMonthProfitList);
		model.addAttribute("pagination",pagination);
		
		return "/admin/profit/adminProfitListMonth";
	}
	
	
	@GetMapping("/adminProfitListYear")
	public String adminGetUserProfitListYear (Model model
												,@RequestParam(defaultValue="1", required=false) int curPage																								
												,@RequestParam(value="searchYear", required = false, defaultValue = "") String searchYear												
												,@RequestParam(value="searchId", required = false, defaultValue = "") String searchId) {
		
		int listCnt = adminProfitMapper.yearProfitListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		List<ProfitYear> adminGetUserYearProfitList = adminProfitMapper.adminGetUserYearProfitList(pagination.getStartIndex(), pagination.getPageSize(), searchYear, searchId);
		
		model.addAttribute("title","회원 연별 수익 목록(조회)");
		model.addAttribute("adminGetUserYearProfitList",adminGetUserYearProfitList);
		model.addAttribute("pagination",pagination);
		
		return "/admin/profit/adminProfitListYear";
	}
	
	
	@GetMapping("/adminModifyProfit")
	public String adminModifyUserProfit (Model model) {
		
		model.addAttribute("title","회원 수익 수정");
		
		return "/admin/profit/adminModifyProfit";
	}

}
