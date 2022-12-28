package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/addUser")
	public String addUser(Model model) {
		model.addAttribute("title", "회원가입");
		return "user/user/addUser";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "로그인");
		return "user/user/login";
	}
}
