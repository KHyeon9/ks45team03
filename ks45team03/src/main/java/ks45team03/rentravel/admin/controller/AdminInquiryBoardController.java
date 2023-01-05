package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.dto.InquiryBoard;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.mapper.InquiryBoardMapper;
import ks45team03.rentravel.user.service.InquiryBoardService;

@Controller
@RequestMapping("/admin/board")
public class AdminInquiryBoardController {
	
	private final InquiryBoardService inquiryBoardService;
	private final InquiryBoardMapper inquiryBoardMapper;
	
	public AdminInquiryBoardController(InquiryBoardService inquiryBoardService, InquiryBoardMapper inquiryBoardMapper) {
		this.inquiryBoardService = inquiryBoardService;
		this.inquiryBoardMapper = inquiryBoardMapper;
	}

	@GetMapping("/adminInquiryList")
	public String adminGetInquiryBoardList (Model model
											,@RequestParam(defaultValue="1", required=false) int curPage) {
		
		int listCnt = inquiryBoardMapper.inquiryBoardListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		
		List<InquiryBoard> adminGetInquiryBoardList = inquiryBoardMapper.getInquiryBoardList(pagination.getStartIndex(), pagination.getPageSize());
		List<InquiryBoard> adminGetInquiryReBoardList = inquiryBoardMapper.getInquiryBoardReList();
		
		
		model.addAttribute("title","1 대 1 문의 게시글 목록(조회)");
		model.addAttribute("adminGetInquiryBoardList",adminGetInquiryBoardList);
		model.addAttribute("pagination",pagination);
		model.addAttribute("adminGetInquiryReBoardList",adminGetInquiryReBoardList);
		
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
