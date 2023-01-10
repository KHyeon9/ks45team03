package ks45team03.rentravel.user.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.Profit;
import ks45team03.rentravel.dto.ProfitDay;
import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.mapper.UserBlockMapper;
import ks45team03.rentravel.mapper.UserMapper;
import ks45team03.rentravel.mapper.UserProfitMapper;
import ks45team03.rentravel.user.service.OrderService;
import ks45team03.rentravel.user.service.ProfitService;
import ks45team03.rentravel.user.service.UserService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/myPage")
public class MyPageController {
	
	private final UserBlockMapper userBlockMapper;
	private final UserProfitMapper userProfitMapper;
	private final OrderService orderService;
	private final UserService userService;
	private final UserMapper userMapper;
	private final ProfitService profitService;
	
	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);
	
	@GetMapping("/myPage")
	public String myPage(Model model, HttpSession session) {
	
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String redirectURI = "user/myPage/myPage";
		
		if(loginUser == null) {
		
			redirectURI = "redirect:/login";	
			
		}else {
			
			model.addAttribute("title", "내 정보");
			
		}
		return redirectURI;
		
	}
	
	@PostMapping("/myInfo")
	public String myInfo(User user) {
								
		userMapper.ModifyuserInfo(user);
		
		return "redirect:/myPage/myInfo";
	}
	
	@GetMapping("/myInfo")
	public String myInfo(Model model, HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String loginNickName = loginUser.getLoginNickName();
		String loginId = loginUser.getLoginId();
		User userInfo = userMapper.userInfo(loginId);
		
		List<RegionSido> regionSidoCode = userMapper.getMyPageRegionSido(userInfo.getRegionSido().getRegionSidoCode());
		
		model.addAttribute("title", "내 정보");
		model.addAttribute("loginNickName", loginNickName);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("regionSidoCode", regionSidoCode);
		
		return "user/myPage/myInfo";
	}
	
	@PostMapping("/checkPassword")
	public String checkPassword(Model model 
								,HttpSession session
								,RedirectAttributes reAttr
								,@RequestParam(value="userPw") String userPw) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String userId = loginInfo.getLoginId();
		
		Map<String, Object> checkResult = userService.checkPwByUserId(userId, userPw);
		
		boolean isChecked = (boolean) checkResult.get("result");
		
		String redirectURI = "redirect:/myPage/myInfo";
		
		if(!isChecked) {
			redirectURI = "redirect:/myPage/checkPassword";
			reAttr.addAttribute("msg", "입력하신 비밀번호가 일치하지 않습니다.");
		}else {
			redirectURI = "redirect:/myPage/myInfo";
		}
		
		return redirectURI;
	}
	
	@GetMapping("/checkPassword")
	public String checkPassword(Model model
								,@RequestParam(value="msg", required = false) String msg) {
		
		model.addAttribute("title", "비밀번호 확인");
		if(msg != null) model.addAttribute("msg", msg);
		
		return "user/myPage/checkPassword";
	}
	
	@GetMapping("/modifyUser")
	public String modifyUser(Model model) {
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
									,HttpSession session
									,@RequestParam(defaultValue="1", required=false) int curPage) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		int listCnt = userBlockMapper.blockListCnt(loginUser.getLoginId());
		
		Pagination pagination = new Pagination(listCnt, curPage);
				
		List<Block> getUserBlockList = userBlockMapper.getUserBlockList(loginUser.getLoginId(),pagination.getStartIndex(), pagination.getPageSize());
		
		String loginNickName = loginUser.getLoginNickName();	
		
		model.addAttribute("title","나의 차단 리스트");
		model.addAttribute("getUserBlockList",getUserBlockList);
		model.addAttribute("pagination",pagination);
		model.addAttribute("loginNickName",loginNickName);
		
		return "user/myPage/myBlockList";
	}
	
	
	
	@GetMapping("/myProfitList")
	public String getUserProfitList(Model model
									,HttpSession session
									,@RequestParam(defaultValue="1", required=false) int curPage) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");	
		int listCnt = userProfitMapper.profitListCnt(loginUser.getLoginId());
		
		Pagination pagination = new Pagination(listCnt, curPage);
		
		
		List<Profit> getUserProfitList = userProfitMapper.getUserProfitList(loginUser.getLoginId(),pagination.getStartIndex(), pagination.getPageSize());
		
		String loginNickName = loginUser.getLoginNickName();
		
		model.addAttribute("title","나의 수익목록 리스트");
		model.addAttribute("loginNickName",loginNickName);
		model.addAttribute("getUserProfitList",getUserProfitList);
		model.addAttribute("pagination",pagination);
		
		
		return "user/myPage/myProfitList";
	}
	
	
	@GetMapping("/myProfitListDay")
	public String getUserProfitListDay (Model model
										,HttpSession session
										,@RequestParam(defaultValue="1", required=false) int curPage
										,@RequestParam(value="searchYear", required = false) String searchYear
										,@RequestParam(value="searchMonth", required = false, defaultValue = "") String searchMonth
										,@RequestParam(value="searchDay", required = false, defaultValue = "") String searchDay
										,@RequestParam(value="profitDayGroup", required = false, defaultValue = "") String profitDayGroup
										
										) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		int listCnt = userProfitMapper.dayProfitListCnt(loginUser.getLoginId());
		
		Pagination pagination = new Pagination(listCnt, curPage);
		List<ProfitDay> getUserDayProfitList = profitService.getUserDayProfitList(loginUser.getLoginId(), pagination.getStartIndex(), pagination.getPageSize(), searchYear, searchMonth, searchDay, profitDayGroup);
		
		System.out.println(searchYear+"년도");
		System.out.println(searchDay+"<-일");
		
		String loginNickName = loginUser.getLoginNickName();
		
		model.addAttribute("title","나의 일별 수익목록 리스트");
		model.addAttribute("loginNickName",loginNickName);
		model.addAttribute("getUserDayProfitList",getUserDayProfitList);
		model.addAttribute("pagination",pagination);
		
		return "user/myPage/myProfitListDay";
		
	}	
	
	
	@GetMapping("/myProfitListMonth")
	public String getUserProfitListMonth (Model model
											,HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String loginNickName = loginUser.getLoginNickName();
		
		model.addAttribute("title","나의 월별 수익목록 리스트");
		model.addAttribute("loginNickName",loginNickName);
		
		return "user/myPage/myProfitListMonth";
		
	}
	
	
	@GetMapping("/myProfitListYear")
	public String getUserProfitListYear (Model model
										,HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String loginNickName = loginUser.getLoginNickName();
		
		model.addAttribute("title","나의 연별 수익목록 리스트");
		model.addAttribute("loginNickName",loginNickName);
		
		return "user/myPage/myProfitListYear";
	}
 	
	
	@GetMapping("/myExperience")
	public String myExperience(Model model) {
		model.addAttribute("title","나의 경험치");
		return "user/myPage/myExperience";
	}
}
