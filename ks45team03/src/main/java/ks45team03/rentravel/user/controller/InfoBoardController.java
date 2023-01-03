package ks45team03.rentravel.user.controller;

import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.InfoBoardComment;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.user.service.InfoBoardService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/infoboard")
@AllArgsConstructor
@Slf4j
public class InfoBoardController {
	
	private final InfoBoardService infoBoardService;
	private final CommonNewCode commonNewCode;
	
	

	
	/*
	 * public InfoBoardController(InfoBoardService infoBoardService) {
	 * this.infoBoardService = infoBoardService; }
	 */
	
	@GetMapping("/removeInfoBoard")
	public String removeInfoBoard(Model model) {
		return "redirect:/";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/infoBoardList")
	public String infoBoardList(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
								Model model) {
		Map<String, Object> paramMap = infoBoardService.getInfoBoardList(currentPage);
		
		List<InfoBoard> infoBoardList = (List<InfoBoard>) paramMap.get("infoBoardList");
		int lastPage = (int) paramMap.get("lastPage");
		int startPageNum = (int) paramMap.get("startPageNum");
		int endPageNum = (int) paramMap.get("endPageNum");
		int nextPage = (int) paramMap.get("nextPage");
		int prevPage = (int) paramMap.get("prevPage");

		model.addAttribute("title", "정보게시판리스트");
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("infoBoardList", infoBoardList);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("prevPage", prevPage);
		
		
		return "user/board/infoBoardList";
	}
	
	@GetMapping("/infoBoardDetail")
	public String infoBoardDetail(@RequestParam(value = "infoBoardCode", required = false) String infoBoardCode, 
								  Model model) {
		
		InfoBoard infoBoardDetail = infoBoardService.getInfoBoardDetail(infoBoardCode);
		List<InfoBoardComment> commentList = infoBoardService.getInfoBoardComment(infoBoardCode);
		int commentCnt = infoBoardService.getCommnetCnt(infoBoardCode);
		
		model.addAttribute("title", "정보게시판상세");
		model.addAttribute("infoBoardDetail", infoBoardDetail);
		model.addAttribute("commentList", commentList);
		model.addAttribute("commentCnt", commentCnt);
		
		return "user/board/infoBoardDetail";
	}
	
	@GetMapping("/modifyInfoBoard")
	public String modifyInfoBoard(Model model) {
		
		model.addAttribute("title", "정보게시판수정");
		
		return "user/board/modifyInfoBoard";
	}
	
	@PostMapping("/addInfoBoard")
	public String addInfoBoard(InfoBoard infoBoard,
								Model model) {
		String infoBoardCode = commonNewCode.getCommonNewCode("tb_info_board", "info_board_code");
		System.out.println(infoBoardCode);
		infoBoard.setInfoBoardCode(infoBoardCode);
		
		System.out.println(infoBoard);
		
		model.addAttribute("title", "정보게시판등록");
		
		infoBoardService.addInfoBoard(infoBoard);
		
		return "redirect:/infoboard/infoBoardList";
	}
	@GetMapping("/addInfoBoard")
	public String addInfoBoard(HttpSession session,
								Model model) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		if(loginInfo == null) {
			System.out.println("로그인 부탁합니다.");
			return "redirect:/infoboard/infoBoardList";
		}
		
		
		model.addAttribute("title", "정보게시판등록");
		model.addAttribute("loginId", loginInfo.getLoginId());
		
		return "user/board/addInfoBoard";
	}
}
