package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class InquiryBoardController {

	
	@GetMapping("/inquiryList")
	public String getInquiryBoardList (Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글 목록(조회)");
		
		return "user/board/inquiryList";
	}
	
	
	@GetMapping("inquiryDetail")
	public String getInquiryBoard (Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글(조회)");
		
		return "user/board/inquiryDetail";
	}
	
	
	
	@GetMapping("/addInquiry")
	public String addInquiryBoard(Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글 추가");
		
		return "user/board/addInquiry";
	}
	
	
	@GetMapping("/modifyInquiry")
	public String modifyInquiryBoard (Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글 수정");
		
		return "user/board/modifyInquiry";
	}
	
	
	@GetMapping("/removeInquiry")
	public String removeInquiryBoard (Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글 삭제");
		
		return "user/board/removeInquiry";
	}
}
