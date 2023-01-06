package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.admin.service.AdminInquiryBoardService;
import ks45team03.rentravel.dto.InquiryBoard;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.InquiryBoardMapper;
import ks45team03.rentravel.user.service.InquiryBoardService;

@Controller
@RequestMapping("/admin/board")
public class AdminInquiryBoardController {
	
	private final AdminInquiryBoardService adminInquiryBoardService;
	private final InquiryBoardMapper inquiryBoardMapper;
	private final CommonNewCode commonNewCode;
	
	public AdminInquiryBoardController(AdminInquiryBoardService adminInquiryBoardService, InquiryBoardMapper inquiryBoardMapper, CommonNewCode commonNewCode) {
		this.adminInquiryBoardService =adminInquiryBoardService;
		this.inquiryBoardMapper = inquiryBoardMapper;
		this.commonNewCode = commonNewCode;
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
	public String adminGetInquiryBoard (@RequestParam(value="inquiryBoardCode", required = false) String inquiryBoardCode
										,Model model) {
		InquiryBoard adminGetInquiryBoard = inquiryBoardMapper.getInquiryBoard(inquiryBoardCode);
		
		model.addAttribute("title","1 대 1 문의 게시글(조회)");
		model.addAttribute("adminGetInquiryBoard",adminGetInquiryBoard);
		
		return "admin/board/adminInquiryDetail";
	}
	
	
	@GetMapping("/adminInquiryReDetail")
	public String adminGetInquiryReBoard (@RequestParam(value = "inquiryReBoardCode", required = false) String inquiryReBoardCode
											,String inquiryReTitle
											,Model model) {
		
		InquiryBoard adminGetInquiryReBoard = inquiryBoardMapper.getInquiryReBoard(inquiryReBoardCode);
	
		model.addAttribute("title","1 대 1 문의 답변 게시글(조회)");
		model.addAttribute("adminGetInquiryReBoard",adminGetInquiryReBoard);
		model.addAttribute("inquiryReTitle",inquiryReTitle);
		
		return "admin/board/adminInquiryReDetail";
	}
	
	
	@GetMapping("/adminAddInquiry")
	public String adminAddInquiryBoard (Model model
										,@RequestParam(value="inquiryBoardCode", required = false) String inquiryBoardCode) {										
		
		InquiryBoard inquiryUserInfo = inquiryBoardMapper.getInquiryBoard(inquiryBoardCode);
	
		
		model.addAttribute("title","1 대 1 문의 게시글 답글 추가");
		model.addAttribute("inquiryUserInfo",inquiryUserInfo);
		
		return "admin/board/adminAddInquiry";
	}
	
	
	@PostMapping("/adminAddInquiry")
	public String adminAddInquiryBoard(InquiryBoard inquiryBoard) {
		
		String inquiryReBoardCode = commonNewCode.getCommonNewCode("tb_inquiry_re_board", "inquiry_re_board_code");
		
		inquiryBoard.setInquiryReBoardCode(inquiryReBoardCode);
		
		adminInquiryBoardService.adminAddInquiryBoard(inquiryBoard);
		
		return "redirect:/admin/board/adminInquiryList";
	}
	
	

	
	
	@GetMapping("/adminRemoveInquiry")
	public String adminRemoveInquiryBoard (Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글 답글 삭제");
		
		return "admin/board/adminRemoveInquiry";
	}
	
}
