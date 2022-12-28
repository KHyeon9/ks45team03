package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/insurance")
public class AdminInsuranceController {
	
	@GetMapping("/adminInsuranceList")
	public String adminGetInsuranceList(Model model) {
		
		model.addAttribute("title", "관리자 보험리스트");
		return "admin/insurance/adminInsuranceList";
	}
	
	@GetMapping("/adminRemoveInsurance")
	public String adminAddInsurancePayout(Model model) {
		
		model.addAttribute("title", "관리자 보험 삭제");
		return "admin/insurance/adminRemoveInsurance.html";
	}
	
	@GetMapping("/adminInsuranceBillList")
	public String adminGetInsuranceRequestList(Model model) {
		
		model.addAttribute("title", "관리자 보험청구서리스트");
		return "admin/insurance/adminInsuranceBillList";
	}
	
	@GetMapping("/adminInsuranceBillPayoutList")
	public String adminGetInsurancePayoutList(Model model) {
		
		model.addAttribute("title", "관리자 보상금지급내역");
		return "admin/insurance/adminInsuranceBillPayoutList";
	}
	
	@GetMapping("/adminAddInsuranceBillPayout")
	public String adminRemoveInsuranceById(Model model) {
		
		model.addAttribute("title", "관리자 보상금 지급내역 등록");
		return "admin/insurance/adminAddInsuranceBillPayout";
	}
	

}