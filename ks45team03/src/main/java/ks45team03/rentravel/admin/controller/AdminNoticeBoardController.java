package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/board")
public class AdminNoticeBoardController {

	@GetMapping("/adminNoticeBoard")
	public String adminNoticeBoard(Model model) {
		
		model.addAttribute("title", "공지사항");
		
	return "admin/board/adminNoticeBoard";
	}
	
	@GetMapping("/adminAddNoticeBoard")
	public String adminAddNoticeBoard(Model model) {
		
		model.addAttribute("title", "공지사항 등록");
		
	return "admin/board/adminAddNoticeBoard";
	}
	
	@GetMapping("/adminDetailNoticeBoard")
	public String adminDetailNoticeBoard(Model model) {
			
		model.addAttribute("title", "공지사항 상세보기");
		
	return "admin/board/adminDetailNoticeBoard";
	}
	
	@GetMapping("/adminModifyNoticeBoard")
	public String adminModifyNoticeBoard(Model model) {
			
		model.addAttribute("title", "공지사항 수정");
		
	return "admin/board/adminModifyNoticeBoard";
	}

}
