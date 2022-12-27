package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@GetMapping("/addUser")
	public String addUser() {
		
		return "user/user/addUser";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "user/user/login";
	}
}
