package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/board")
public class AdminFaqBoardController {

	@GetMapping("/adminFaq")
	public String adminFaq(Model model) {
		
		model.addAttribute("title", "FAQ");
		
	return "admin/board/adminFaq";
	}
	
	@GetMapping("/adminAddFaq")
	public String adminAddFaq(Model model) {
		
		model.addAttribute("title", "FAQ 등록");
		
	return "admin/board/adminAddFaq";
	}
	
	@GetMapping("/adminDetailFaq")
	public String adminDetailFaq(Model model) {
			
		model.addAttribute("title", "FAQ 상세보기");
		
	return "admin/board/adminDetailFaq";
	}
	
	@GetMapping("/adminModifyFaq")
	public String adminModifyFaq(Model model) {
			
		model.addAttribute("title", "FAQ 수정");
		
	return "admin/board/adminModifyFaq";
	}
}
