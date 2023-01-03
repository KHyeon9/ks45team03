package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.user.service.UserBlockService;

@Controller
@RequestMapping("/user/block")
public class UserBlockController {
	
	private final UserBlockService userBlockService;
	
	public UserBlockController (UserBlockService userBlockService) {
		
		this.userBlockService = userBlockService;
	}

	@GetMapping("/removeBlock")
	public String removeUserBlock (Model model) {
		
		model.addAttribute("title","회원 아이디 차단 삭제");
		return "user/block/removeBlock";
	}
	
	
	
	@PostMapping("/addUserBlock")
	public String addUserBlock(String userId
										,HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		userBlockService.addUserBlock(userId, loginUser.getLoginId());
		
		
		return "redirect:/myPage/myBlockList";

	}			
	
}
