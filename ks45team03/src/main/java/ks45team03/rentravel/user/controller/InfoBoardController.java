package ks45team03.rentravel.user.controller;

import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.InfoBoardComment;
import ks45team03.rentravel.user.service.InfoBoardService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@RequestMapping("/infoboard")
@AllArgsConstructor
public class InfoBoardController {
	
	private final InfoBoardService infoBoardService;
	
	
	private static final Logger log = LoggerFactory.getLogger(InfoBoardController.class);

	
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
		
		model.addAttribute("title", "정보게시판상세");
		model.addAttribute("infoBoardDetail", infoBoardDetail);
		model.addAttribute("commentList", commentList);
		
		return "user/board/infoBoardDetail";
	}
	
	@GetMapping("/modifyInfoBoard")
	public String modifyInfoBoard(Model model) {
		model.addAttribute("title", "정보게시판수정");
		
		return "user/board/modifyInfoBoard";
	}
	
	@GetMapping("/addInfoBoard")
	public String addInfoBoard(Model model) {
		model.addAttribute("title", "정보게시판등록");
		
		return "user/board/addInfoBoard";
	}
}
