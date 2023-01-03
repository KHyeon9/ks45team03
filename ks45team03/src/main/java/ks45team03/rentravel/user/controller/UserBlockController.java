package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.mapper.UserBlockMapper;
import ks45team03.rentravel.user.service.UserBlockService;

@Controller
@RequestMapping("/user/block")
public class UserBlockController {
	
	private final UserBlockService userBlockService;
	private final UserBlockMapper userBlockMapper;
	
	public UserBlockController (UserBlockService userBlockService, UserBlockMapper userBlockMapper) {
		
		this.userBlockService = userBlockService;
		this.userBlockMapper = userBlockMapper;
	}
	


	@PostMapping("/removeBlock")
	public String removeUserBlock (@RequestParam(value="blockedUserId") String blockedUserId
									,HttpSession session
									,Model model) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String redirectURI ="user/myPage/myBlockList";
		
		if(loginUser == null) {
			
			redirectURI = "redirect:/";		

		}else {
		
		userBlockService.removeUserBlock(blockedUserId);
		List<Block> getUserBlockList = userBlockMapper.getUserBlockList(loginUser.getLoginId());
		
		String loginNickName = loginUser.getLoginNickName();	
		
		model.addAttribute("title","나의 차단 리스트");
		model.addAttribute("getUserBlockList",getUserBlockList);
		model.addAttribute("loginNickName",loginNickName);
		
		
		}
		return redirectURI;
	}
	
	
	
	@PostMapping("/addUserBlock")
	public String addUserBlock(String userId
								,HttpSession session
								,Model model) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String redirectURI ="user/myPage/myBlockList";
		
		if(loginUser == null) {
			
			redirectURI = "redirect:/";		

		}else {
		
		
		userBlockService.addUserBlock(userId, loginUser.getLoginId());
		List<Block> getUserBlockList = userBlockMapper.getUserBlockList(loginUser.getLoginId());
		
		String loginNickName = loginUser.getLoginNickName();	
		
		model.addAttribute("title","나의 차단 리스트");
		model.addAttribute("getUserBlockList",getUserBlockList);
		model.addAttribute("loginNickName",loginNickName);

		
		}
		
		return redirectURI;

	}			
	
}
