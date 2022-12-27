package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/insurance")
public class AdminInsuranceController {
	
	@GetMapping("/adminInsuranceList")
	public String getAdminInsuranceList(Model model) {
		
		System.out.println("InsuranceController adminInsuranceList 관리자보험리스트");
		
		model.addAttribute("title", "관리자 보험리스트");
		return "admin/insurance/adminInsuranceList";
	}
	
	@GetMapping("/adminInsuranceBillList")
	public String getAdminInsuranceRequestList(Model model) {
		
		System.out.println("InsuranceController adminInsuranceBillList 관리자보험청구서리스트");
		
		model.addAttribute("title", "관리자 보험청구서리스트");
		return "admin/insurance/adminInsuranceBillList";
	}
	
	@GetMapping("/adminInsuranceBillPayoutList")
	public String getAdminInsurancePayoutList(Model model) {
		
		System.out.println("InsuranceController adminInsuranceBillPayoutList 관리자보상금지급내역");
		
		model.addAttribute("title", "관리자 보상금지급내역");
		return "admin/insurance/adminInsuranceBillPayoutList";
	}
	

}