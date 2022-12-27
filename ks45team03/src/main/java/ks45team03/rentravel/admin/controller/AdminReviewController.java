package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/review")
public class AdminReviewController {
	
	@GetMapping("/adminReviewList")
	public String adminReviewList(Model model) {
		model.addAttribute("title","관리자 상품평 관리 화면입니다.");
		return "admin/review/adminReviewList";
	}
}
