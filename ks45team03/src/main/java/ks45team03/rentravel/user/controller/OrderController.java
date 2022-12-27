package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/order")
public class OrderController {
	
	@GetMapping("/userPayment")
	public String payment(Model model) {
		model.addAttribute("title", "결제 화면");
		
		return "user/order/userPayment";
	}
	
	@GetMapping("/userWaybill")
	public String addWaybill(Model model) {
		model.addAttribute("title", "운송장 번호 입력");
		
		return "user/order/userWaybill";
	}
}
