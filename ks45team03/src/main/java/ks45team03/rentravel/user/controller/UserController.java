package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ks45team03.rentravel.dto.RegionSgg;
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
	public String addUser(Model model
						  ,@RequestParam(value="regionSggCode") String regionSggCode) {
		
		String address = userService.address(regionSggCode);
		
		model.addAttribute("title", "회원가입");
		model.addAttribute("address",address);
		
		return "user/user/addUser";
	}
	
	@GetMapping("/regionSidoList")
	public String regionSidoList(Model model) {
		
		List<RegionSido> regionSidoList = userService.regionSidoList();
		
		model.addAttribute("title", "주소 찾아가기 테스트");
		model.addAttribute("regionSidoList", regionSidoList);
		
		return "user/user/regionSidoList";
	}
	
	
	@GetMapping("/regionSggList")
	public String regionSggList(Model model
										 ,@RequestParam(value="regionSidoCode") String regionSidoCode) {
		
		List<RegionSgg> regionSggList = userService.regionSggList(regionSidoCode);
		
		model.addAttribute("title", "주소 찾아가기 테스트");
		model.addAttribute("regionSggList", regionSggList);
		
		return "user/user/regionSggList";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "로그인");
		return "user/user/login";
	}
}
