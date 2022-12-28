package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

	@GetMapping("/insuranceList")
	public String getInsuranceList(Model model) {		
		model.addAttribute("title", "보험리스트");
		
		return "user/insurance/insuranceList"; //html경로를 찾아감
	}
	
	@GetMapping("/insuranceBillList")
	public String getInsuranceRequestList(Model model) {		
		model.addAttribute("title", "보험청구서리스트");
		
		return "user/insurance/insuranceBillList";
	}
	
	@GetMapping("/insuranceAddBill")
	public String addInsuranceRequest(Model model) {
		
		model.addAttribute("title", "보상금청구서등록");
		
		return "user/insurance/insuranceAddBill";
	}
	
	@GetMapping("/insuranceModifyBill")
	public String modifyInsuranceRequest(Model model) {		
		model.addAttribute("title", "보상금청구서수정");
		
		return "user/insurance/insuranceModifyBill";
	}
	
	@GetMapping("/insuranceRemoveBill")
	public String removeInsuranceRequestById(Model model) {
		model.addAttribute("title", "보상금청구서삭제");
		
		return "user/insurance/insuranceRemoveBill";
	}
	
	@GetMapping("/insuranceBillListDetail")
	public String getInsuranceRequestInfoByCode(Model model) {
		model.addAttribute("title", "보상금청구서상세화면");
		
		return "user/insurance/insuranceBillListDetail";
	}
	
	@GetMapping("/insuranceBillPayoutList")
	public String getInsurancePayoutList(Model model) {		
		model.addAttribute("title", "보상금지급내역");
		
		return "user/insurance/insuranceBillPayoutList";
	}
	
}
