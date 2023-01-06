package ks45team03.rentravel.user.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.RegionSgg;
import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.mapper.UserMapper;
import ks45team03.rentravel.user.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;
	private final UserMapper userMapper;

	// 닉네임 중복 체크 컨트롤러
	@GetMapping("/addUser/nickNameCheck")
	@ResponseBody
	public boolean nickNameCheck(@RequestParam(value="userNickName") String userNickName) {

		boolean nickNameCheck = false;
		
		nickNameCheck = userMapper.checkUserNickName(userNickName);
		
		return nickNameCheck;
	}
		
	// id 중복 체크 컨트롤러
	@GetMapping("/addUser/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam(value="userId") String userId) {
		
		boolean idCheck = false;
		
		idCheck = userMapper.checkUserId(userId);
			
		return idCheck;
	}
	
	@RequestMapping(value="/addUser/ajaxProject", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<RegionSgg>> ajaxProject(@RequestParam(value="project") String project) throws Exception {
		
		ResponseEntity<List<RegionSgg>> entity = null;
		
		try {
			
			List<RegionSgg> list = userService.selectRegionSgg(project);
			entity = new ResponseEntity<List<RegionSgg>>(list, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			
			entity = new ResponseEntity<List<RegionSgg>> (HttpStatus.BAD_REQUEST);
			
			return entity;
		}
		return entity;
	}
	
	@PostMapping("/addUser")
	public String addUsser(User user) {
		
		userService.addUser(user);
		
		return "redirect:/";
	}

	@GetMapping("/addUser")
	public String addUser(Model model) {
		
		List<RegionSido> getRegionSido = userService.getRegionSido();
		
		model.addAttribute("title", "회원가입");
		model.addAttribute("getRegionSido", getRegionSido);
		
		return "user/user/addUser";
	}
	
	@PostMapping("/login")
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
			redirectURI = "redirect:/login";
			reAttr.addAttribute("msg", "아이디(ID)와 비밀번호를 확인하고 다시 로그인해주세요.");
		} else {
			// 비밀번호 일치
			User user = (User) checkResult.get("userInfo");
			
			LoginInfo loginInfo = new LoginInfo(userId, user.getUserNickName(), user.getUserLevelName());
			
			session.setAttribute("S_USER_INFO", loginInfo);
		}
		
		return redirectURI;
		
	}
	
	
	@GetMapping("/login")
	public String login(Model model
					   ,@RequestParam(value="msg", required=false) String msg) {
		
		model.addAttribute("title", "login");
		if(msg != null) model.addAttribute("msg", msg);
		
		return "user/user/login";
	}	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
}
