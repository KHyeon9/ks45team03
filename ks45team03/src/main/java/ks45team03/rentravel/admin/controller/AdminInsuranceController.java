package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.admin.service.AdminInsuranceService;
import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceClaim;
import ks45team03.rentravel.dto.InsurancePayout;
import ks45team03.rentravel.dto.InsuranceRequest;
import ks45team03.rentravel.mapper.AdminInsuranceMapper;


@Controller
@RequestMapping("/admin/insurance")
public class AdminInsuranceController {
	
	private final AdminInsuranceService adminInsuranceService;
	private final AdminInsuranceMapper adminInsuranceMapper;
	
	public AdminInsuranceController(AdminInsuranceService adminInsuranceService, AdminInsuranceMapper adminInsuranceMapper) {
		this.adminInsuranceService = adminInsuranceService;
		this.adminInsuranceMapper = adminInsuranceMapper;
	}
	
	@GetMapping("/adminInsuranceList")
	public String adminGetInsuranceList(Model model) { // 보험리스트
		
		List<Insurance> adminInsuranceList = adminInsuranceService.adminGetInsuranceList();
		
		model.addAttribute("title", "관리자 보험리스트");
		model.addAttribute("adminInsuranceList", adminInsuranceList);
		
		return "admin/insurance/adminInsuranceList";
	}
	
	
	@GetMapping("/adminRemoveInsurance")
	public String adminAddInsurancePayout(Model model) {
		
		model.addAttribute("title", "관리자 보험 삭제");
		return "admin/insurance/adminRemoveInsurance";
	}
	
	@GetMapping("/adminInsuranceRequestList")
	public String adminGetInsuranceRequestList(Model model) {
		
		List<InsuranceRequest> adminInsuranceRequestList = adminInsuranceService.adminGetInsuranceRequestList();
		
		model.addAttribute("title", "관리자 보상금신청서(상세화면) 조회");
		model.addAttribute("adminInsuranceRequestList", adminInsuranceRequestList);
		
		return "admin/insurance/adminInsuranceRequestList";
	}
	
	
	@GetMapping("/adminInsuranceClaimList")
	public String adminGetInsuranceClaimList(Model model) {
		List<InsuranceClaim> adminInsuranceClaimList = adminInsuranceService.adminGetInsuranceClaimList();
		
		model.addAttribute("title", "관리자 보상금청구상태 조회");
		model.addAttribute("adminInsuranceClaimList", adminInsuranceClaimList);
		
		return "admin/insurance/adminInsuranceClaimList";
	}
	
	
	@GetMapping("/adminInsurancePayoutList")
	public String adminGetInsurancePayoutList(Model model) {
		
		List<InsurancePayout> adminInsurancePayoutList = adminInsuranceService.adminGetInsurancePayoutList();
		
		model.addAttribute("title", "관리자 보상금지급내역");
		model.addAttribute("adminInsurancePayoutList", adminInsurancePayoutList);
		
		return "admin/insurance/adminInsurancePayoutList";
	}
	
	
	@GetMapping("/adminAddInsurancePayout")
	public String adminAddInsuranceBillPayout(Model model) {
		
		model.addAttribute("title", "관리자 보상금 지급내역 등록");
		return "admin/insurance/adminAddInsurancePayout";
	}
	

}