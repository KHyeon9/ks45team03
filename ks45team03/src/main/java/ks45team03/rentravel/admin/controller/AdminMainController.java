package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.LoginInfo;


@Controller
public class AdminMainController {
	
	@GetMapping("/admin")
	public String adminMain(Model model) {
		
		model.addAttribute("title", "관리자 메인화면");
		
		return "admin/main";
	}
}
