package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/board")
public class AdminInquiryBoardController {

	@GetMapping("/adminInquiryList")
	public String adminGetInquiryBoardList (Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글 목록(조회)");
		
		return "admin/board/adminInquiryList";
	}
	
	@GetMapping("/adminInquiryDetail")
	public String adminGetInquiryBoard (Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글(조회)");
		
		return "admin/board/adminInquiryDetail";
	}
	
	@GetMapping("/adminAddInquiry")
	public String adminAddInquiryBoard (Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글 답글 추가");
		
		return "admin/board/adminAddInquiry";
	}
	
	@GetMapping("/adminRemoveInquiry")
	public String adminRemoveInquiryBoard (Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글 답글 삭제");
		
		return "admin/board/adminRemoveInquiry";
	}
	
}
