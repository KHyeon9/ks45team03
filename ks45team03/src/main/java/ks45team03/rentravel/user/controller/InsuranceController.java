package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/insurance")
public class InsuranceController {

	@GetMapping("/userInsuranceList")
	public String getUserInsuranceList(Model model) {
		System.out.println("InsureanceController userInsuranceList 보험리스트");
		
		model.addAttribute("title", "보험리스트");
		
		return "user/insurance/userInsuranceList";
	}
	
	@GetMapping("/userInsuranceBillList")
	public String getUserInsuranceRequestList(Model model) {
		System.out.println("InsureanceController userInsuranceBillList 보험청구서리스트");
		
		model.addAttribute("title", "보험청구서리스트");
		
		return "user/insurance/userInsuranceBillList";
	}
	
	@GetMapping("/userInsuranceBillPayoutList")
	public String getUserInsurancePayoutList(Model model) {
		System.out.println("InsureanceController userInsuranceBillPayoutList 보험금지급내역");
		
		model.addAttribute("title", "보험금지급내역");
		
		return "user/insurance/userInsuranceBillPayoutList";
	}
	
}
