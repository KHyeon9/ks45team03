package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import ks45team03.rentravel.admin.service.AdminInsuranceService;
import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsuranceBillState;
import ks45team03.rentravel.dto.InsurancePayout;
import ks45team03.rentravel.mapper.AdminInsuranceMapper;


@Controller
@RequestMapping("/admin/insurance")
public class AdminInsuranceController {
	
	private final AdminInsuranceMapper adminInsuranceMapper;
	private final AdminInsuranceService adminInsuranceService;
	
	public AdminInsuranceController(AdminInsuranceMapper adminInsuranceMapper, AdminInsuranceService adminInsuranceService) {
		this.adminInsuranceMapper = adminInsuranceMapper;
		this.adminInsuranceService = adminInsuranceService;
	}

	@GetMapping("/adminInsuranceList")
	public String adminGetInsuranceList(Model model) {
		
		List<Insurance> adminInsuranceList = adminInsuranceMapper.adminGetInsuranceList();
		
		model.addAttribute("title", "보험가입정보");
		model.addAttribute("adminInsuranceList", adminInsuranceList);
		
		
		return "admin/insurance/adminInsuranceList"; //html경로를 찾아감
	}
	
	@GetMapping("/adminInsuranceBillList")
	public String adminGetInsuranceBillList(Model model) {
		
		List<InsuranceBill> adminInsuranceBillList = adminInsuranceMapper.adminGetInsuranceBillList();
		
		model.addAttribute("title", "보험청구서");
		model.addAttribute("adminInsuranceBillList", adminInsuranceBillList);
		
		return "admin/insurance/adminInsuranceBillList";
	}
	
	@GetMapping("/adminInsuranceBillDetail")
	public String adminGetInsuranceBillDetail(Model model) {
		
		List<InsuranceBillDetail> adminInsuranceBillDetail = adminInsuranceMapper.adminGetInsuranceBillDetail();
		
		model.addAttribute("title", "보상금청구서상세화면");
		model.addAttribute("adminInsuranceBillDetail", adminInsuranceBillDetail);
		
		return "admin/insurance/adminInsuranceBillDetail";
	}
	
	@GetMapping("/adminInsuranceBillState")
	@ResponseBody
	public List<InsuranceBillState> adminGetInsuranceBillStateList(HttpServletResponse response, Model model) {
		
		List<InsuranceBillState> adminInsuranceBillStateList = adminInsuranceMapper.adminGetInsuranceBillStateList();
		model.addAttribute("adminInsuranceBillStateList", adminInsuranceBillStateList);
		
		return adminInsuranceBillStateList;
	}
	
	
	@GetMapping("/adminInsurancePayoutList")
	public String adminGetInsurancePayoutList(Model model) {
		
		List<InsurancePayout> adminInsurancePayoutList = adminInsuranceMapper.adminGetInsurancePayoutList();
		
		model.addAttribute("title", "보상금지급내역");
		model.addAttribute("adminInsurancePayoutList", adminInsurancePayoutList);
		
		return "admin/insurance/adminInsurancePayoutList";
	}
	
	@GetMapping("/adminAddInsurancePayout")
	public String adminAddInsurancePayoutList(Model model) {
		model.addAttribute("title", "보상금지급내역등록");
		
		return "admin/insurance/adminAddInsurancePayout";
	}
	
	@PostMapping("/adminAddInsurancePayout")
	public String adminAddInsurancePayoutList(InsurancePayout insurancePayout, Model model) {
		System.out.println("");
		model.addAttribute("title", "보상금지급내역등록");
		
		adminInsuranceMapper.adminAddInsurancePayout(insurancePayout);
		
		return "admin/insurance/adminAddInsurancePayout";
	}
	
}
