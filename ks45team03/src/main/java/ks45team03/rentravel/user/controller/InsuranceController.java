package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsurancePayout;
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
		
		List<Insurance> insuranceList = insuranceService.getInsuranceList();
		
		model.addAttribute("title", "보험가입정보");
		model.addAttribute("insuranceList", insuranceList);
		
		
		return "user/insurance/insuranceList"; //html경로를 찾아감
	}
	
	@GetMapping("/insuranceBillList")
	public String getInsuranceBillList(Model model) {		
		
		List<InsuranceBill> insuranceBillList = insuranceService.getInsuranceBillList();
		
		model.addAttribute("title", "보험청구서");
		model.addAttribute("insuranceBillList", insuranceBillList);
		
		return "user/insurance/insuranceBillList";
	}
	
	@GetMapping("/insuranceBillDetail")
	public String getInsuranceBillDetail(Model model) {
		
		List<InsuranceBillDetail> insuranceBillDetail = insuranceService.getInsuranceBillDetail();
		
		model.addAttribute("title", "보상금청구서상세화면");
		model.addAttribute("insuranceBillDetail", insuranceBillDetail);
		
		
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
		
		List<InsurancePayout> insurancePayoutList = insuranceService.getInsurancePayoutList();
		
		model.addAttribute("title", "보상금지급내역");
		model.addAttribute("insurancePayoutList", insurancePayoutList);
		
		return "user/insurance/insurancePayoutList";
	}
	
}
