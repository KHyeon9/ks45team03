package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/myPage")
public class MyPageController {
	
	@GetMapping("")
	public String myPage(Model model) {
		model.addAttribute("title","마이페이지 화면");
		return "user/myPage/myPage";
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
}
