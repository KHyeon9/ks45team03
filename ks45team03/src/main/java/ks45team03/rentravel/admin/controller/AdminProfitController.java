package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/profit")
public class AdminProfitController {
	
	@GetMapping("/adminProfitList")
	public String adminGetUserProfitList (Model model) {
		
		model.addAttribute("title","회원 수익 목록(조회)");
		
		return "/admin/profit/adminProfitList";
	}
	
	@GetMapping("/adminModifyProfit")
	public String adminModifyUserProfit (Model model) {
		
		model.addAttribute("title","회원 수익 수정");
		
		return "/admin/profit/adminModifyProfit";
	}

}
