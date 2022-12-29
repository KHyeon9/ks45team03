package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.mapper.UserMapper;
import ks45team03.rentravel.user.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/addUser")
	public String addUser(Model model) {
		
		List<RegionSido> regionSidoList = userService.regionSidoList();
		
		model.addAttribute("title", "회원가입");
		model.addAttribute("regionSidoList", regionSidoList);
		
		return "user/user/addUser";
	}
	
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "로그인");
		return "user/user/login";
	}
}
