package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.admin.service.AdminProfitService;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.Profit;
import ks45team03.rentravel.mapper.AdminProfitMapper;

@Controller
@RequestMapping("/admin/profit")
public class AdminProfitController {
	
	private final AdminProfitMapper adminProfitMapper;
	private final AdminProfitService adminProfitService;
	
	public AdminProfitController (AdminProfitMapper adminProfitMapper, AdminProfitService adminProfitService) {
		
		this.adminProfitMapper = adminProfitMapper;
		this.adminProfitService = adminProfitService;
	}
	
	
	@GetMapping("/adminProfitList")
	public String adminGetUserProfitList (Model model
											,@RequestParam(defaultValue="1", required=false) int curPage
											,@RequestParam(value="userId", required = false, defaultValue = "") String userId
											,@RequestParam(value="searchId", required = false, defaultValue = "") String searchId) {
		
		int listCnt = adminProfitMapper.profitListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		
		List<Profit> adminGetUserProfitList =  adminProfitService.adminGetUserProfitList(pagination.getStartIndex(), pagination.getPageSize(), searchId, userId);
		
		
		model.addAttribute("title","회원 수익 목록(조회)");
		model.addAttribute("adminGetUserProfitList",adminGetUserProfitList);
		model.addAttribute("pagination",pagination);
		
		return "/admin/profit/adminProfitList";
	}
	
	
	@GetMapping("/adminProfitListDay")	
	public String adminGetUserProfitListDay (Model model
											,@RequestParam(defaultValue="1", required=false) int curPage
											,@RequestParam(value="profitDayGroup", required = false, defaultValue = "") String profitDayGroup
											,@RequestParam(value="searchYear", required = false, defaultValue = "") String searchYear
											,@RequestParam(value="searchMonth", required = false, defaultValue = "") String searchMonth
											,@RequestParam(value="searchDay", required = false, defaultValue = "") String searchDay
											,@RequestParam(value="userId", required = false, defaultValue = "") String userId
											,@RequestParam(value="searchId", required = false, defaultValue = "") String searchId) {
		
		int listCnt = adminProfitMapper.dayProfitListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		
		List<Profit> adminGetUserDayProfitList = adminProfitService.adminGetUserDayProfitList(pagination.getStartIndex(), pagination.getPageSize(), profitDayGroup, searchYear, searchMonth, searchDay, searchId, userId);
		
		model.addAttribute("title","회원 일별 수익 목록(조회)");
		model.addAttribute("adminGetUserDayProfitList",adminGetUserDayProfitList);
		model.addAttribute("pagination",pagination);
		
		return "/admin/profit/adminProfitListDay";
	}
	
	
	@GetMapping("/adminProfitListMonth")	
	public String adminGetUserProfitListMonth (Model model) {
		
		model.addAttribute("title","회원 월별 수익 목록(조회)");
		
		return "/admin/profit/adminProfitListMonth";
	}
	
	
	@GetMapping("/adminProfitListYear")
	public String adminGetUserProfitListYear (Model model) {
		
		model.addAttribute("title","회원 연별 수익 목록(조회)");
		
		return "/admin/profit/adminProfitListYear";
	}
	
	
	@GetMapping("/adminModifyProfit")
	public String adminModifyUserProfit (Model model) {
		
		model.addAttribute("title","회원 수익 수정");
		
		return "/admin/profit/adminModifyProfit";
	}

}
