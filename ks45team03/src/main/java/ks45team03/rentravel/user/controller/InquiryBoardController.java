package ks45team03.rentravel.user.controller;

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
@RequestMapping("/board")
public class InquiryBoardController {
	
	private final InquiryBoardService inquiryBoardService;
	private final InquiryBoardMapper inquiryBoardMapper;
	
	public InquiryBoardController (InquiryBoardService inquiryBoardService, InquiryBoardMapper inquiryBoardMapper) {
		this.inquiryBoardService = inquiryBoardService;
		this.inquiryBoardMapper = inquiryBoardMapper;
	}
	
	@GetMapping("/inquiryList")
	public String getInquiryBoardList (Model model
										,@RequestParam(defaultValue="1", required=false) int curPage) {
		
		int listCnt = inquiryBoardMapper.inquiryBoardListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		List <InquiryBoard> getInquiryBoardList = inquiryBoardMapper.getInquiryBoardList(pagination.getStartIndex(), pagination.getPageSize());
				
		model.addAttribute("title","1 대 1 문의 게시글 목록(조회)");
		model.addAttribute("getInquiryBoardList",getInquiryBoardList);
		model.addAttribute("pagination",pagination);
		
		return "user/board/inquiryList";
	}
	
	
	@GetMapping("/inquiryDetail")
	public String getInquiryBoard (@RequestParam(value="inquiryBoardCode", required = false) String inquiryBoardCode
									,Model model) {
		
		InquiryBoard getInquiryBoard = inquiryBoardMapper.getInquiryBoard(inquiryBoardCode);
		model.addAttribute("title","1 대 1 문의 게시글(조회)");
		model.addAttribute("getInquiryBoard",getInquiryBoard);
		
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
