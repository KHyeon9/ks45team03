package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.admin.service.AdminReviewService;
import ks45team03.rentravel.dto.Review;

@Controller
@RequestMapping("/admin/review")
public class AdminReviewController {
	
	private final AdminReviewService adminReviewService;
	
	public AdminReviewController(AdminReviewService adminReviewService) {
		this.adminReviewService = adminReviewService;
	}
	
	@GetMapping("/adminReviewList")
	public String adminReviewList(Model model) {
		
		List<Review> adminReviewList = adminReviewService.getAdminReviewList();
		
		model.addAttribute("adminReviewList",adminReviewList);
		model.addAttribute("title","관리자 상품평 관리 화면입니다.");
		
		return "admin/review/adminReviewList";
	}
	
	@PostMapping("/removeAdminReview")
	public String removeAdminReview(String reviewCode) {
		
		adminReviewService.removeAdminReviewReport(reviewCode);
		adminReviewService.removeAdminReviewMileage(reviewCode);
		adminReviewService.removeAdminReview(reviewCode);
		
		return "redirect:/admin/review/adminReviewList";
	}
}
