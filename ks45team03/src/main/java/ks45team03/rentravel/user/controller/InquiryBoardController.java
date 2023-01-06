package ks45team03.rentravel.user.controller;

import static org.junit.Assert.fail;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.InquiryBoard;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.InquiryBoardMapper;
import ks45team03.rentravel.user.service.InquiryBoardService;

@Controller
@RequestMapping("/board")
public class InquiryBoardController {
	
	private final InquiryBoardService inquiryBoardService;
	private final InquiryBoardMapper inquiryBoardMapper;
	private final CommonNewCode commonNewCode;
	
	public InquiryBoardController (InquiryBoardService inquiryBoardService, InquiryBoardMapper inquiryBoardMapper, CommonNewCode commonNewCode) {
		this.inquiryBoardService = inquiryBoardService;
		this.inquiryBoardMapper = inquiryBoardMapper;
		this.commonNewCode = commonNewCode;
	}
	
	@GetMapping("/inquiryList")
	public String getInquiryBoardList (Model model
										,@RequestParam(defaultValue="1", required=false) int curPage) {
		
		int listCnt = inquiryBoardMapper.inquiryBoardListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		List <InquiryBoard> getInquiryBoardList = inquiryBoardMapper.getInquiryBoardList(pagination.getStartIndex(), pagination.getPageSize());
		List <InquiryBoard> getInquiryBoardReList = inquiryBoardMapper.getInquiryBoardReList();
				
		model.addAttribute("title","1 대 1 문의 게시글 목록(조회)");
		model.addAttribute("getInquiryBoardList",getInquiryBoardList);
		model.addAttribute("pagination",pagination);
		model.addAttribute("getInquiryBoardReList",getInquiryBoardReList);
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
	
	
	@GetMapping("/inquiryReDetail")
	public String getInquiryReBoard (@RequestParam(value="inquiryReBoardCode", required = false) String inquiryReBoardCode
									,Model model) {
		
		InquiryBoard getInquiryReBoard = inquiryBoardMapper.getInquiryReBoard(inquiryReBoardCode);
		model.addAttribute("title","1 대 1 문의 게시글(조회)");
		model.addAttribute("getInquiryReBoard",getInquiryReBoard);
		
		return "user/board/inquiryReDetail";
	}
	
	
	
	@GetMapping("/addInquiry")
	public String addInquiryBoard(Model model
								,HttpSession session) {
		 
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		String levelName = loginInfo.getLoginLevelName();
		
		model.addAttribute("title","1 대 1 문의 게시글 추가");
		model.addAttribute("loginId",loginInfo.getLoginId());
		model.addAttribute("levelName",levelName);
		
		
		return "user/board/addInquiry";
	}
	
	
	@PostMapping("/addInquiry")
	public String addInquiryBoard(InquiryBoard inquiryBoard) {
		
		String inquiryBoardCode = commonNewCode.getCommonNewCode("tb_inquiry_board", "inquiry_board_code");
		inquiryBoard.setInquiryBoardCode(inquiryBoardCode);
		inquiryBoardService.addInquiryBoard(inquiryBoard);
		
		return "redirect:/board/inquiryList";
	}
	
	
	@GetMapping("/modifyInquiry")
	public String modifyInquiryBoard (@RequestParam(value="inquiryBoardCode", required = false) String inquiryBoardCode
									,HttpSession session
									,Model model) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		InquiryBoard getInquiryBoard = inquiryBoardMapper.getInquiryBoard(inquiryBoardCode);
		
		model.addAttribute("title","1 대 1 문의 게시글 수정");
		model.addAttribute("loginId",loginInfo.getLoginId());
		model.addAttribute("getInquiryBoard",getInquiryBoard);
		
		return "user/board/modifyInquiry";
	}
	
	
	@PostMapping("/modifyInquiry")
	public String modifyInquiryBoard(InquiryBoard inquiryBoard) {
		
		inquiryBoardService.modifyInquiryBoard(inquiryBoard);
		return "redirect:/board/inquiryList";
	}
	
	
	@GetMapping("/removeInquiry")
	public String removeInquiryBoard (Model model) {
		
		model.addAttribute("title","1 대 1 문의 게시글 삭제");
		
		return "user/board/removeInquiry";
	}
}
