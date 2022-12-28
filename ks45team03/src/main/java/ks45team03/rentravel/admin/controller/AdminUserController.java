package ks45team03.rentravel.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.admin.service.AdminUserService;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.dto.UserLevel;

@Controller
@RequestMapping("/admin/userManagement")
public class AdminUserController {
	
	// 의존성 주입
	private final AdminUserService adminUserService;
	
	public AdminUserController (AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	// 회원목록 + 페이징
	@SuppressWarnings("unchecked")
	@GetMapping("/userList")
	public String userList(Model model
			 ,@RequestParam(value="currentPage", defaultValue = "1", required = false) int currentPage) {
		
		Map<String, Object> paramMap = adminUserService.userList(currentPage);
		int lastPage = (int) paramMap.get("lastPage");
		List<User> userList = (List<User>) paramMap.get("userList");
		
		int startPageNum = (int) paramMap.get("startPageNum");
		int endPageNum = (int) paramMap.get("endPageNum");
		int nextPage = (int) paramMap.get("nextPage");
		int prevPage = (int) paramMap.get("prevPage");
		
		model.addAttribute("title", "유저목록");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("userList", userList);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("prevPage", prevPage);
		
		return "admin/userManagement/userList";
	}
	
	// 수정 처리
	@PostMapping("/modifyUser")
	public String modifyUser(User user) {
		
		adminUserService.modifyUser(user);
		
		return "redirect:/admin/userManagement/userList";
	}
	
	// 특정회원 조회해서 수정화면으로 --> userLevelCode :: userLevelName 
	@GetMapping("/modifyUser")
	public String modifyUser(Model model
							 ,@RequestParam(value="userId", required=false) String userId) {
		
		User userInfo = adminUserService.getUserInfoById(userId);
		List<UserLevel> userLevelList = adminUserService.getUserLevelList();
		
		model.addAttribute("title", "수정화면");
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("userLevelList", userLevelList);
		
		return "admin/userManagement/modifyUser";
	}
}