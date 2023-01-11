package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.user.service.WishService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/wish")
public class WishController {
	
	private final WishService wishService;
	private final CommonNewCode commonNewCode;
	
	@PostMapping("/addWish")
	public String addWish(HttpSession session
						,String goodsCode
						,String userId) {
		String wishCode = commonNewCode.getCommonNewCode("tb_wish", "wish_code");
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String loginId = loginUser.getLoginId();
		
		wishService.addWish(wishCode, goodsCode, loginId);
		
		return "redirect:/goods/goodsDetail?goodsCode="+goodsCode+"&userId="+userId;
	}
	
	@PostMapping("/removeWish")
	public String removeWish(HttpSession session
							,String goodsCode
							,String userId
							,String prevPage) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String loginId = loginUser.getLoginId();
		
		wishService.removeAlarmWish(goodsCode, loginId);
		wishService.removeWish(goodsCode, loginId);
		
		String redirectURI = "";
		
		if(prevPage.equals("goodsDetail")) {
			redirectURI = "redirect:/goods/goodsDetail?goodsCode="+goodsCode+"&userId="+userId;
		}else if(prevPage.equals("myWishList")) {
			redirectURI = "redirect:/myPage/myWishList";
		}
		
		return redirectURI;
	}
}
