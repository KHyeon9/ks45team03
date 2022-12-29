package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping("/payment")
	public String payment(@RequestParam(value = "goodsCode", required = false) String goodsCode,
						  Model model) {
		model.addAttribute("title", "결제 화면");
		
		return "user/order/payment";
	}
	
	@GetMapping("/waybill")
	public String addWaybill(Model model) {
		model.addAttribute("title", "운송장 번호 입력");
		
		return "user/order/waybill";
	}
}