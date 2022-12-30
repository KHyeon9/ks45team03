package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.admin.service.AdminCommisionRateService;
import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.mapper.UserBlockMapper;
import ks45team03.rentravel.user.service.UserBlockService;

@Controller
@RequestMapping("/myPage")
public class MyPageController {
	
	private final UserBlockService userBlockService;
	private final UserBlockMapper userBlockMapper;
	
	public MyPageController (UserBlockService userBlockService, UserBlockMapper userBlockMapper) {
		this.userBlockService = userBlockService;	
		this.userBlockMapper = userBlockMapper;	
	}
	
	
	@GetMapping("/myInfo")
	private String myInfo(Model model) {
		model.addAttribute("title", "내 정보");
		return "user/myPage/myPage";
	}
	
	@GetMapping("/modifyUser")
	private String modifyUser(Model model) {
		model.addAttribute("title", "회원정보 수정");
		return "user/myPage/modifyUser";
	}
	
	@GetMapping("/removeUser")
	private String removeUser(Model model) {
		model.addAttribute("title", "탈퇴 화면");
		return "user/myPage/removeUser";
	}
	
	@GetMapping("/myGoodsList")
	public String myGoodsList(Model model) {
		model.addAttribute("title","마이페이지 화면");
		return "user/myPage/myGoodsList";
	}
	
	@GetMapping("/myReviewList")
	public String myReviewList(Model model) {
		model.addAttribute("title","마이페이지 화면");
		return "user/myPage/myReviewList";
	}
	
	@GetMapping("/myWishList")
	public String myWishList(Model model) {
		model.addAttribute("title","마이페이지 화면");
		return "user/myPage/myWishList";
	}
	@GetMapping("/myOrderHistory")
	public String myOrderHistory(Model model) {
		model.addAttribute("title","마이페이지 주문 내역");
		return "user/myPage/myOrderHistory";
	}
	
	@GetMapping("/userEvaluation")
	public String userEvaluation(Model model) {
		model.addAttribute("title","내 평가");
		return "user/myPage/userEvaluation";
	}
	
	@GetMapping("/userEvaluated")
	public String userEvaluated(Model model) {
		model.addAttribute("title","내가 한 평가");
		return "user/myPage/userEvaluated";
	}
	
	@GetMapping("/myBlockList")
	public String getUserBlockrList(Model model
									,HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		
		List<Block> getUserBlockrList = userBlockMapper.getUserBlockrList(loginUser.getLoginId());
		
		String loginNickName = loginUser.getLoginNickName();
		
	
		
		model.addAttribute("title","나의 차단 리스트");
		model.addAttribute("getUserBlockrList",getUserBlockrList);
		model.addAttribute("loginNickName",loginNickName);
		
		return "user/myPage/myBlockList";
	}
	
	@GetMapping("/myProfitList")
	public String getUserProfitList(Model model) {
		
		model.addAttribute("title","나의 수익목록 리스트");
		return "user/myPage/myProfitList";
	}
	
	@GetMapping("/myExperience")
	public String myExperience(Model model) {
		model.addAttribute("title","나의 경험치");
		return "user/myPage/myExperience";
	}
}
