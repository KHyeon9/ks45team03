package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/report")
public class AdminReportController {
	
	@GetMapping("/adminReportList")
	public String adminGetReportList(Model model) {
		model.addAttribute("title", "관리자 신고 목록");
		
		return "/admin/report/adminReportList";
	}
	
	@GetMapping("/adminReportDetail")
	public String adminGetReportDetail(Model model) {
		model.addAttribute("title", "관리자 신고 상세");
		return "/admin/report/adminReportDetail";
	}

}
