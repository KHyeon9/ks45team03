package ks45team03.rentravel.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.admin.service.AdminCommisionRateService;
import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.UserBlockMapper;
import ks45team03.rentravel.mapper.UserMapper;
import ks45team03.rentravel.user.service.InfoBoardService;
import ks45team03.rentravel.user.service.OrderService;
import ks45team03.rentravel.user.service.UserBlockService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/myPage")
public class MyPageController {
	
	private final UserBlockMapper userBlockMapper;
	private final OrderService orderService;
	private final UserMapper userMapper;
	
	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);
	
	@GetMapping("/myInfo")
	private String myInfo(Model model, HttpSession session) {
		
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String redirectURI = "user/myPage/myPage";
		
		if(loginUser == null) {
					
			redirectURI = "redirect:/login";	
	
		}else {
		
		String loginNickName = loginUser.getLoginNickName();
		String loginId = loginUser.getLoginId();
		User userInfo = userMapper.userInfo(loginId);
		
		model.addAttribute("title", "내 정보");
		model.addAttribute("loginNickName", loginNickName);
		model.addAttribute("userInfo", userInfo);
		
		}
		return redirectURI;
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
	@GetMapping("/myOrderList")
	public String myOrderHistory(HttpSession session,
								 Model model) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		String redirectURI = "user/myPage/myOrderList";
		
		if (loginInfo == null) {
			redirectURI = "redirect:/";
		
		} else {
			List<Rental> orderList = orderService.getUserOrderList(loginInfo.getLoginId());
			model.addAttribute("title","마이페이지 주문 내역");
			model.addAttribute("orderList", orderList);
		}
		
		
		return redirectURI;
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
		String redirectURI = "user/myPage/myBlockList";
		
		if(loginUser == null) {
			
			redirectURI = "redirect:/";		

		}else {
		
		List<Block> getUserBlockList = userBlockMapper.getUserBlockList(loginUser.getLoginId());
		
		String loginNickName = loginUser.getLoginNickName();	
		
		model.addAttribute("title","나의 차단 리스트");
		model.addAttribute("getUserBlockList",getUserBlockList);
		model.addAttribute("loginNickName",loginNickName);


		}
		
		return redirectURI;
	}
	
	
	
	@GetMapping("/myProfitList")
	public String getUserProfitList(Model model
									,HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String redirectURI = "user/myPage/myProfitList";
		
		if(loginUser == null) {
					
			redirectURI = "redirect:/";		
	
		}else {
		String loginNickName = loginUser.getLoginNickName();
		
		model.addAttribute("title","나의 수익목록 리스트");
		model.addAttribute("loginNickName",loginNickName);
		
		}
		return redirectURI;
	}
	
	
	@GetMapping("/myExperience")
	public String myExperience(Model model) {
		model.addAttribute("title","나의 경험치");
		return "user/myPage/myExperience";
	}
}
