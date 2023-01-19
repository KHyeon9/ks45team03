package ks45team03.rentravel.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.admin.service.AdminUserService;
import ks45team03.rentravel.dto.LoginHistory;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.Search;
import ks45team03.rentravel.dto.SleeperAccount;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.dto.UserLevel;
import ks45team03.rentravel.mapper.AdminUserMapper;

@Controller
@RequestMapping("/admin/userManagement")
public class AdminUserController {
	
	// 의존성 주입
	private final AdminUserService adminUserService;
	private final AdminUserMapper adminUserMapper;
	
	public AdminUserController (AdminUserService adminUserService, AdminUserMapper adminUserMapper) {
		this.adminUserService = adminUserService;
		this.adminUserMapper = adminUserMapper;
	}
	
	// 회원목록 + 페이징
	@SuppressWarnings("unchecked")
	@GetMapping("/userList")
	public String userList(Model model
			 ,@RequestParam(value="currentPage", defaultValue = "1", required = false) int currentPage
			 ,@RequestParam(value="searchKey", required = false) String searchKey
			 ,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue) {
		
		// 회원 목록 리스트
		Map<String, Object> paramMap = adminUserService.userList(currentPage, searchKey, searchValue);
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
	
	@GetMapping("/loginHistory")
	public String loginHistory(Model model
							  ,HttpSession session
							  ,@RequestParam(defaultValue="1", required=false) int curPage
							  ,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue) {
		
		int listCnt = adminUserMapper.loginHistoryCnt(searchValue);
		Pagination pagination = new Pagination(listCnt, curPage);
		Search search = new Search(searchValue);
		List<LoginHistory> loginHistory = adminUserMapper.loginHistory(pagination.getStartIndex(), pagination.getPageSize(), searchValue);
		
		model.addAttribute("title", "로그인 이력");
		model.addAttribute("loginHistory", loginHistory);
		model.addAttribute("pagination", pagination);
		model.addAttribute("search", search);
		
		return "admin/userManagement/loginHistory";
	}
	
	@GetMapping("/sleeperAccount")
	public String sleeperAccount(Model model
			 					,@RequestParam(defaultValue="1", required=false) int curPage
			 					,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue) {
		
		int listCnt = adminUserMapper.sleeperAccountCnt(searchValue);
		Pagination pagination = new Pagination(listCnt, curPage);
		Search search = new Search(searchValue);
		List<SleeperAccount> sleeperAccountList = adminUserMapper.sleeperAccountList(pagination.getStartIndex(), pagination.getPageSize(), searchValue);
		
		model.addAttribute("title", "휴면계정 목록");
		model.addAttribute("sleeperAccountList", sleeperAccountList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("search", search);
		
		return "admin/userManagement/sleeperAccount";
	}
	
	@GetMapping("/removeAccount")
	public String removeAccount(Model model) {
		model.addAttribute("title", "탈퇴계정 목록");
		
		return "admin/userManagement/removeAccount";
	}
}
