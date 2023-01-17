package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		userBlockService.removeUserBlock(blockedUserId);
		
		String loginNickName = loginUser.getLoginNickName();	
		
		model.addAttribute("title","나의 차단 리스트");
		model.addAttribute("loginNickName",loginNickName);
		
		
		
		return "redirect:/myPage/myBlockList";
	}
	
	
	@ResponseBody
	@PostMapping("/addUserBlock")
	public int addUserBlock(@RequestBody String userId
								,HttpSession session ) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		System.out.println(userId+"<-userId");
				
		userBlockService.addUserBlock(userId, loginUser.getLoginId());		
		int userBlockedIdCnt = userBlockMapper.userBlockListCnt(userId, loginUser.getLoginId());
		
		return userBlockedIdCnt;
		
	}			
	
}
