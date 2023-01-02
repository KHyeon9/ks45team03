package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.mapper.InsuranceMapper;
import ks45team03.rentravel.user.service.InsuranceService;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {
	
	private final InsuranceMapper insuranceMapper;
	private final InsuranceService insuranceService;
	
	public InsuranceController(InsuranceMapper insuranceMapper, InsuranceService insuranceService) {
		this.insuranceMapper = insuranceMapper;
		this.insuranceService = insuranceService;
	}
	
	@GetMapping("/insuranceMain")
	public String insuranceMain(Model model) {		
		model.addAttribute("title", "보험메인화면");
		
		return "user/insurance/insuranceMain";
	}

	@GetMapping("/insuranceList")
	public String getInsuranceList(Model model) {		
		model.addAttribute("title", "보험가입정보");
		
		return "user/insurance/insuranceList"; //html경로를 찾아감
	}
	
	@GetMapping("/insuranceBillList")
	public String getInsuranceBillList(Model model) {		
		model.addAttribute("title", "보험청구서");
		
		return "user/insurance/insuranceBillList";
	}
	
	@GetMapping("/insuranceBillDetail")
	public String getInsuranceRequestInfoByCode(Model model) {
		model.addAttribute("title", "보상금청구서상세화면");
		
		return "user/insurance/insuranceBillDetail";
	}
	
	@GetMapping("/insuranceAddBill")
	public String addInsuranceBillDetail(Model model) {
		
		model.addAttribute("title", "보상금청구서등록");
		
		return "user/insurance/insuranceAddBill";
	}
	
	@GetMapping("/insuranceModifyBill")
	public String modifyInsuranceBillDetail(Model model) {		
		model.addAttribute("title", "보상금청구서수정");
		
		return "user/insurance/insuranceModifyBill";
	}
	
	@GetMapping("/insuranceRemoveBill")
	public String removeInsuranceBillDetail(Model model) {
		model.addAttribute("title", "보상금청구서삭제");
		
		return "user/insurance/insuranceRemoveBill";
	}
	
	@GetMapping("/insurancePayoutList")
	public String getInsurancePayoutList(Model model) {		
		model.addAttribute("title", "보상금지급내역");
		
		return "user/insurance/insurancePayoutList";
	}
	
}
