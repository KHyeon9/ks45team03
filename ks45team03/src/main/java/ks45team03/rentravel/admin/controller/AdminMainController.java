package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.LoginInfo;


@Controller
public class AdminMainController {
	
	@GetMapping("/admin")
	public String adminMain(Model model, HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String redirectURI = "admin/main";
		
		if(loginUser == null) {
		
			redirectURI = "redirect:/login";	
			
		}else if(loginUser.getLoginLevelName().equals("관리자")){
			
			model.addAttribute("title", "관리자 메인화면");
			
		}else {
			
			redirectURI = "redirect:/";	
		}
		
		return redirectURI;
	}
}
