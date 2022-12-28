package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/infoboard")
public class InfoBoardController {
	@GetMapping("/infoBoardList")
	public String infoBoardList(Model model) {
		model.addAttribute("title", "정보게시판리스트");
		
		return "user/board/infoBoardList";
	}
	
	@GetMapping("/infoBoardDetail")
	public String infoBoardDetail(Model model) {
		model.addAttribute("title", "정보게시판상세");
		
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
