package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/insurance")
public class InsuranceController {

	@GetMapping("/userInsuranceList")
	public String getInsuranceList(Model model) {		
		model.addAttribute("title", "보험리스트");
		
		return "user/insurance/userInsuranceList";
	}
	
	@GetMapping("/userInsuranceBillList")
	public String getInsuranceRequestList(Model model) {		
		model.addAttribute("title", "보험청구서리스트");
		
		return "user/insurance/userInsuranceBillList";
	}
	
	@GetMapping("/userInsuranceAddBill")
	public String addInsuranceRequest(Model model) {
		
		model.addAttribute("title", "보상금청구서등록");
		
		return "user/insurance/userInsuranceAddBill";
	}
	
	@GetMapping("/userInsuranceModifyBill")
	public String modifyInsuranceRequest(Model model) {		
		model.addAttribute("title", "보상금청구서수정");
		
		return "user/insurance/userInsuranceModifyBill";
	}
	
	@GetMapping("/userInsuranceRemoveBill")
	public String removeInsuranceRequestById(Model model) {
		model.addAttribute("title", "보상금청구서삭제");
		
		return "user/insurance/userInsuranceRemoveBill";
	}
	
	@GetMapping("/userInsuranceBillListDetail")
	public String getInsuranceRequestInfoByCode(Model model) {
		model.addAttribute("title", "보상금청구서상세화면");
		
		return "user/insurance/userInsuranceBillListDetail";
	}
	
	@GetMapping("/userInsuranceBillPayoutList")
	public String getInsurancePayoutList(Model model) {		
		model.addAttribute("title", "보상금지급내역");
		
		return "user/insurance/userInsuranceBillPayoutList";
	}
	
}
