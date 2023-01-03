package ks45team03.rentravel.user.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.user.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/addUser")
	public String addUser(Model model) {
		
		model.addAttribute("title", "회원가입");
		
		return "user/user/addUser";
	}
	
	@PostMapping("/")
	public String login(@RequestParam(value="userId") String userId
					   ,@RequestParam(value="userPw") String userPw
					   ,RedirectAttributes reAttr
					   ,HttpSession session
					   ,HttpServletRequest request
					   ,HttpServletResponse response) {
		
		Map<String, Object> checkResult = userService.checkPwByUserId(userId, userPw);
		
		boolean isChecked = (boolean) checkResult.get("result");
		
		String redirectURI = "redirect:/";
		
		// 비밀번호 미일치시
		if(!isChecked) {
			redirectURI = "redirect:/";
			reAttr.addAttribute("msg", "아이디(ID)와 비밀번호를 확인하고 다시 로그인해주세요.");
		} else {
			// 비밀번호 일치
			User user = (User) checkResult.get("userInfo");
			
			LoginInfo loginInfo = new LoginInfo(userId, user.getUserNickName(), user.getUserLevelName());
			
			session.setAttribute("S_USER_INFO", loginInfo);
			
		}
		
		return redirectURI;
		
	}
	
	
	@GetMapping("/")
	public String login(Model model
					   ,@RequestParam(value="msg", required=false) String msg) {
		
		model.addAttribute("title", "RENTravel");
		if(msg != null) model.addAttribute("msg", msg);
		
		return "user/main";
	}	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
}
