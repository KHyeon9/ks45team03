package ks45team03.rentravel.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.Profit;
import ks45team03.rentravel.dto.ProfitDay;
import ks45team03.rentravel.dto.ProfitMonth;
import ks45team03.rentravel.dto.ProfitSearch;
import ks45team03.rentravel.dto.ProfitYear;
import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.RentalCancel;
import ks45team03.rentravel.dto.Review;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.dto.UserEvaluation;
import ks45team03.rentravel.dto.UserEvaluationType;
import ks45team03.rentravel.dto.WaybillOwner;
import ks45team03.rentravel.dto.WaybillRenter;
import ks45team03.rentravel.dto.Wish;
import ks45team03.rentravel.mapper.OrderMapper;
import ks45team03.rentravel.mapper.UserBlockMapper;
import ks45team03.rentravel.mapper.UserMapper;
import ks45team03.rentravel.user.service.GoodsService;
import ks45team03.rentravel.mapper.UserProfitMapper;
import ks45team03.rentravel.user.service.OrderService;
import ks45team03.rentravel.user.service.ProfitService;
import ks45team03.rentravel.user.service.ReviewService;
import ks45team03.rentravel.user.service.UserService;
import ks45team03.rentravel.user.service.WishService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/myPage")
public class MyPageController {
	
	private final UserBlockMapper userBlockMapper;
	private final UserProfitMapper userProfitMapper;
	private final OrderService orderService;
	private final OrderMapper orderMapper;
	private final UserService userService;
	private final UserMapper userMapper;
	private final GoodsService goodsService;
	private final ProfitService profitService;
	private final ReviewService reviewService;
	private final WishService wishService;
	
	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);
	
	@PostMapping("/myInfo")
	public String myInfo(User user) {
								
		userMapper.ModifyuserInfo(user);
		
		return "redirect:/myPage/myInfo";
	}
	
	@GetMapping("/myInfo")
	public String myInfo(Model model, HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String loginId = loginUser.getLoginId();
		String loginNickName = loginUser.getLoginNickName();
		User userInfo = userMapper.userInfo(loginId);
		
		List<RegionSido> regionSidoCode = userMapper.getMyPageRegionSido(userInfo.getRegionSido().getRegionSidoCode());
		
		model.addAttribute("title", "내 정보");
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("regionSidoCode", regionSidoCode);
		model.addAttribute("loginNickName", loginNickName);
		
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
		
		String redirectURI;
		
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
	
	@RequestMapping("/removeUser")
	private String removeUser(HttpSession session){
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		userMapper.removeUser(loginInfo.getLoginId());
		userMapper.setRemoveAccount(loginInfo.getLoginId());
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/myGoodsList")
	public String myGoodsList(Model model
							 ,HttpSession session
							 ,@RequestParam(defaultValue="1", required=false) int curPage
							 ,HttpServletResponse response) throws IOException {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		if (loginUser == null) {
			CommonController.alertPlzLogin(response);
			
			return "user/user/login";
		}
		String loginId = loginUser.getLoginId();
		
		int myGoodsListCount = goodsService.getMyGoodsListCount(loginId);

		Pagination pagination = new Pagination(myGoodsListCount, curPage);
		
		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();
		
		List<Goods> myGoodsList = goodsService.getMyGoodsList(loginUser.getLoginId(),startIndex,pageSize);
		
		model.addAttribute("myGoodsList",myGoodsList);
		model.addAttribute("pagination",pagination);
		model.addAttribute("title","마이페이지 화면");
		
		return "user/myPage/myGoodsList";
	}
	
	@PostMapping("/myRemoveGoods")
	public String myRemoveGoods(@RequestParam(value="goodsCode") String goodsCode) {
		
		goodsService.removeGoods(goodsCode);
		
		return "redirect:/myPage/myGoodsList";
	}
	
	@GetMapping("/myReviewList")
	public String myReviewList(Model model
							  ,HttpSession session
							  ,@RequestParam(defaultValue="1", required=false) int curPage) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String loginId ="";
		String returnURI ="";
		
		if(loginUser == null) {
			returnURI = "redirect:/login";
		}else {
			loginId = loginUser.getLoginId();	
			returnURI = "user/myPage/myReviewList";
		}
		
			
		
		int myReviewListCount = reviewService.getMyReviewListCount(loginId);
		
		Pagination pagination = new Pagination(myReviewListCount, curPage);
		
		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();
	
		List<Review> myReviewList = reviewService.getMyReviewList(loginId, startIndex, pageSize);
		
		model.addAttribute("title","마이페이지 화면");
		model.addAttribute("myReviewList",myReviewList);
		model.addAttribute("pagination",pagination);
		
		
		return returnURI;
	}
	
	@GetMapping("/myWishList")
	public String myWishList(Model model
							,HttpSession session
							,@RequestParam(defaultValue="1", required=false) int curPage) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String loginId ="";
		String returnURI ="";
		
		if(loginUser == null) {
			returnURI = "redirect:/login";
		}else {
			loginId = loginUser.getLoginId();	
			returnURI = "user/myPage/myWishList";
		}
		
		int wishListCount = wishService.getWishListCount(loginId);
		
		Pagination pagination = new Pagination(wishListCount, curPage);
		
		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();
		
		List<Wish> wishList = wishService.getWishList(loginId, startIndex, pageSize);
		
		model.addAttribute("title","마이페이지 화면");
		model.addAttribute("wishList",wishList);
		model.addAttribute("pagination",pagination);
		
		return returnURI;
	}
	
	// 주문 취소 확인
	@PostMapping("/rentalCancelCheck")
	public String rentalCancelCheck(String paymentCode) {
		
		orderService.cancelCheckOwner(paymentCode);
		
		return "redirect:/myPage/myRentList";
	}
	
	// 주문 취소
	@PostMapping("/rentalCancel")
	public String rentalCancel(String paymentCode, HttpSession session) {
		
		log.info("payment code : {}", paymentCode);
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String loginId = loginInfo.getLoginId();
		
		orderService.rentalCancel(paymentCode, loginId);
		
		return "redirect:/myPage/myOrderList";
	}
	
	// 렌트 물품  배송 정보 가져오기
	@ResponseBody
	@PostMapping("/getRentDeliveryInfo")
	public WaybillRenter getRentDeliveryInfo(@RequestBody String paymentCode, HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String userId = loginUser.getLoginId();
		
		return orderMapper.getRentDeliveryInfo(userId, paymentCode);
		
	}
	
	// 반납 처리
	@PostMapping("/returnCheck")
	public String returnCheck(@RequestParam(value = "paymentCode" ) String paymentCode) {
		
		orderService.modifyPaymentState(paymentCode, "trade_status6");
		
		return "redirect:/myPage/myRentList";
	}
	
	// 렌트 운송장번포 추가 post
	@PostMapping("/addMyRentWaybill")
	public String modifyMyRent(HttpSession session
								, WaybillOwner waybillOwner
								,@RequestParam(value = "paymentCode" ) String paymentCode								
								,@RequestParam(value = "settlementAmount") int settlementAmount) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");			
		
		String dayGroupCode = profitService.getUserDayGroupCode(paymentCode, loginUser.getLoginId());	
		String monthGroupCode = profitService.getUserMonthGroupCode(paymentCode, loginUser.getLoginId());
		String profitSaveYearMonth = profitService.getProfitSaveYearMonth(monthGroupCode);
	
		System.out.println(profitSaveYearMonth+"획득년월");
		System.out.println(monthGroupCode+"<-월별수익코드");
		
		waybillOwner.setPaymentCode(paymentCode);
		waybillOwner.setOwnerId(loginUser.getLoginId());
		
		orderService.addWaybillOwner(waybillOwner, paymentCode);
		
		log.info("waybillOwner : {} ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", waybillOwner);
		
		
		profitService.addUserProfit(paymentCode, loginUser.getLoginId(), settlementAmount, dayGroupCode);
		profitService.addUserDayProfit(dayGroupCode, loginUser.getLoginId(), settlementAmount, profitSaveYearMonth, monthGroupCode);
		profitService.addUserMonthProfit(monthGroupCode, loginUser.getLoginId(), settlementAmount, profitSaveYearMonth);	
		profitService.addUserYearProfit(profitSaveYearMonth, paymentCode, loginUser.getLoginId());
		
		return "redirect:/myPage/myRentList";
	}
	
	// 오너의 운송장 번호 입력
	@GetMapping("/addMyRentWaybill")
	public String modifyMyRent(@RequestParam( value = "rentalCode", required=false) String rentalCode,
							   Model model) {
		Rental rentalInfo = orderService.getRentalGoodsInfo(rentalCode);
		model.addAttribute("rentalInfo", rentalInfo);
		
		return "user/myPage/addMyRentWaybill";
	}
	
	// 상품 렌트 목록
	@GetMapping("/myRentList")
	public String myRentList(HttpServletResponse response, 
							 HttpSession session, 
							 Model model,
							 @RequestParam(defaultValue="1", required=false) int curPage) throws IOException {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		if (loginInfo == null) {
			CommonController.alertPlzLogin(response);
			
			return "redirect:/";
		}
		
		int userRentCnt = orderMapper.getUserRentCnt(loginInfo.getLoginId());
		
		Pagination pagination = new Pagination(userRentCnt, curPage);
		
		List<Rental> rentList = orderService.getUserRentList(loginInfo.getLoginId(), pagination.getStartIndex(), pagination.getPageSize());
		model.addAttribute("title","마이페이지 렌트 내역");
		model.addAttribute("rentList", rentList);
		model.addAttribute("pagination", pagination);
		
		return "user/myPage/myRentList";
	}
	
	// 주문 배송 정보 가져오기
	@ResponseBody
	@PostMapping("/getOrderDeliveryInfo")
	public WaybillOwner getOrderDeliveryInfo(@RequestBody String paymentCode, HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String userId = loginUser.getLoginId();
		
		return orderMapper.getOrderDeliveryInfo(userId, paymentCode);
		
	}
	
	// 렌터의 상품 수령
	@PostMapping("/receiptCheck")
	public String receiptCheck(String paymentCode) {
		
		orderService.modifyPaymentState(paymentCode, "trade_status4");
		
		return "redirect:/myPage/myOrderList";
	}
	
	// 렌터의 운송장 번호 입력 post
	@PostMapping("/addMyOrderWaybill")
	public String addMyOrderWaybill(WaybillRenter waybillRenter,
									String paymentCode,
									HttpSession session) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		waybillRenter.setPaymentCode(paymentCode);
		waybillRenter.setRenterId(loginInfo.getLoginId());
		
		log.info("waybillRenter {} ~~~~~~~~~~~~~~~~", waybillRenter);
		
		orderService.addWaybillRenter(waybillRenter, paymentCode);
		
		
		return "redirect:/myPage/myOrderList";
	}
	
	// 렌터의 운송장 번호 입력 get
	@GetMapping("/addMyOrderWaybill")
	public String addMyOrderWaybill(@RequestParam( value = "rentalCode", required=false) String rentalCode,
							   Model model) {
		Rental orderInfo = orderMapper.getOrderGoodsInfo(rentalCode);
		model.addAttribute("orderInfo", orderInfo);
		
		return "user/myPage/addMyOrderWaybill";
	}
	
	// 반납 직거래 완료
	@PostMapping("/directTransactionReturn")
	public String directTransactionReturn(String paymentCode) {
		
		orderService.directTransactionReturn(paymentCode);
		
		return "redirect:/myPage/myRentList";
	}

	// 주문 직거래 완료
	@PostMapping("/directTransactionOrder")
	public String directTransactionOrder(String paymentCode) {
		
		orderService.directTransactionOrder(paymentCode);
		
		return "redirect:/myPage/myOrderList";
	}
	
	// 상품 주문 목록
	@GetMapping("/myOrderList")
	public String myOrderHistory(HttpServletResponse response,
								 HttpSession session,
								 Model model,
								 @RequestParam(defaultValue="1", required=false) int curPage) throws IOException {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		String redirectURI = "user/myPage/myOrderList";
		
		if (loginInfo == null) {
			CommonController.alertPlzLogin(response);
			redirectURI = "user/user/login";
		
		} else {
			int userOrderCnt = orderMapper.getUserOrderCnt(loginInfo.getLoginId());
			
			Pagination pagination = new Pagination(userOrderCnt, curPage);
			
			List<Rental> orderList = orderService.getUserOrderList(loginInfo.getLoginId(), pagination.getStartIndex(), pagination.getPageSize());
			model.addAttribute("title","마이페이지 주문 내역");
			model.addAttribute("orderList", orderList);
			model.addAttribute("pagination", pagination);
		}
		
		
		return redirectURI;
	}
	
	@GetMapping("/userEvaluation")
	public String userEvaluation(Model model
								,HttpSession session) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");

		
		List<UserEvaluation> userEvaluation = userService.userEvaluation(loginInfo.getLoginId());
		
		model.addAttribute("title","내 평가");
		model.addAttribute("userEvaluation", userEvaluation);
		
		return "user/myPage/userEvaluation";
	}
	
	@PostMapping("/addUserEvaluation")
	public String addUserEvaluation(@RequestParam(value="userNickName") String userNickName
								   ,@RequestParam(value="userEvaluationTypeCodeList") List<String> userEvaluationTypeCodeList
								   ,HttpSession session) {
		
		
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		userMapper.addUserEvaluation(userNickName, userEvaluationTypeCodeList, loginInfo.getLoginId());
		
		return "redirect:" + session.getAttribute("referer");
	}
	
	@GetMapping("/addUserEvaluation")
	public String addUserEvaluation(Model model, @RequestParam(value="userNickName") String userNickName
									,HttpSession session
								    ,HttpServletRequest request) {
		
		String referer = request.getHeader("Referer");
		
		if (!referer.contains("/login")) {
			session.setAttribute("referer", referer);
	    }
		
		
			List<UserEvaluationType> userEvaluationList = userMapper.userEvaluationList();
			
			model.addAttribute("title", "회원평가");
			model.addAttribute("userNickName", userNickName);
			model.addAttribute("userEvaluationList", userEvaluationList);
		
		return "user/myPage/addUserEvaluation";
	}
	
	@GetMapping("/addUserEvalueationDone")
	public String addUserEvalueationDone(Model model, @RequestParam(value="userNickName") String userNickName, HttpSession session ,HttpServletRequest request) {
		
		String referer = request.getHeader("Referer");
		
		if (!referer.contains("/login")) {
			session.setAttribute("referer", referer);
	    }
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		List<UserEvaluation> getUserEvaluationDoneList = userMapper.getUserEvaluationDoneList(userNickName, loginInfo.getLoginId());
		
		model.addAttribute("title", "회원평가");
		model.addAttribute("userNickName", userNickName);
		model.addAttribute("getUserEvaluationDoneList", getUserEvaluationDoneList);
		
		return "user/myPage/addUserEvalueationDone";
	}
	
	@PostMapping("/modifyEvaluationAjax")
	@ResponseBody
	public List<UserEvaluationType> modifyEvaluation(){
		
		List<UserEvaluationType> userEvaluationList = userMapper.userEvaluationList();
		
		return userEvaluationList;
	}
	
	@PostMapping("/modifyUserEvaluation")
	public String modifyUserEvaluation(@RequestParam(value="userNickName") String userNickName
								   ,@RequestParam(value="userEvaluationTypeCodeList") List<String> userEvaluationTypeCodeList
								   ,HttpSession session) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		userMapper.deleteUserEvaluation(userNickName, loginInfo.getLoginId());
		userMapper.addUserEvaluation(userNickName, userEvaluationTypeCodeList, loginInfo.getLoginId());
		
		return "redirect:" + session.getAttribute("referer");
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
										,@RequestParam(value="searchId", required = false, defaultValue = "") String searchId) {
		
		if(searchDay.length() == 1) {
					
					searchDay = "0" + searchDay;
				}
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		int listCnt = userProfitMapper.dayProfitListCnt(loginUser.getLoginId(),searchYear,searchMonth,searchDay);
		
		Pagination pagination = new Pagination(listCnt, curPage);
		ProfitSearch profitSearch = new ProfitSearch(searchId, searchYear, searchMonth, searchDay);
		
		List<ProfitDay> getUserDayProfitList = userProfitMapper.getUserDayProfitList(loginUser.getLoginId(), pagination.getStartIndex(), pagination.getPageSize(), searchYear, searchMonth, searchDay);
		
		System.out.println(searchYear+"년도");
		System.out.println(searchDay+"<-일");
		
		String loginNickName = loginUser.getLoginNickName();
		
		model.addAttribute("title","나의 일별 수익목록 리스트");
		model.addAttribute("loginNickName",loginNickName);
		model.addAttribute("getUserDayProfitList",getUserDayProfitList);
		model.addAttribute("pagination",pagination);
		model.addAttribute("profitSearch",profitSearch);
		
		return "user/myPage/myProfitListDay";
		
	}	
	
	
	@GetMapping("/myProfitListMonth")
	public String getUserProfitListMonth (Model model
											,HttpSession session
											,@RequestParam(defaultValue="1", required=false) int curPage
											,@RequestParam(value="searchYear", required = false) String searchYear
											,@RequestParam(value="searchMonth", required = false, defaultValue = "") String searchMonth
											,@RequestParam(value="searchDay", required = false, defaultValue = "") String searchDay
											,@RequestParam(value="searchId", required = false, defaultValue = "") String searchId
											) {

		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		int listCnt =  userProfitMapper.MonthProfitListCnt(loginUser.getLoginId(),searchYear,searchMonth);
		
			
		Pagination pagination = new Pagination(listCnt, curPage);
		ProfitSearch profitSearch = new ProfitSearch(searchId, searchYear, searchMonth, searchDay);
		
		List<ProfitMonth> getUserMonthProfitList = userProfitMapper.getUserMonthProfitList(loginUser.getLoginId(), pagination.getStartIndex(), pagination.getPageSize(), searchYear, searchMonth);
		
		String loginNickName = loginUser.getLoginNickName();
		
		model.addAttribute("title","나의 월별 수익목록 리스트");
		model.addAttribute("loginNickName",loginNickName);
		model.addAttribute("getUserMonthProfitList",getUserMonthProfitList);
		model.addAttribute("pagination",pagination);
		model.addAttribute("profitSearch",profitSearch);
		
		return "user/myPage/myProfitListMonth";
		
	}
	
	
	@GetMapping("/myProfitListYear")
	public String getUserProfitListYear (Model model
										,HttpSession session
										,@RequestParam(defaultValue="1", required=false) int curPage	
										,@RequestParam(value="searchYear", required = false, defaultValue = "") String searchYear
										,@RequestParam(value="searchMonth", required = false, defaultValue = "") String searchMonth
										,@RequestParam(value="searchDay", required = false, defaultValue = "") String searchDay
										,@RequestParam(value="searchId", required = false, defaultValue = "") String searchId
										) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		int listCnt = userProfitMapper.YearProfitListCnt(loginUser.getLoginId(),searchYear);
		
		Pagination pagination = new Pagination(listCnt, curPage);
		ProfitSearch profitSearch = new ProfitSearch(searchId, searchYear, searchMonth, searchDay);
		
		List<ProfitYear> getUserYearProfitList = userProfitMapper.getUserYearProfitList(loginUser.getLoginId(), pagination.getStartIndex(), pagination.getPageSize(), searchYear);
		
		String loginNickName = loginUser.getLoginNickName();
		
		model.addAttribute("title","나의 연별 수익목록 리스트");
		model.addAttribute("loginNickName",loginNickName);
		model.addAttribute("getUserYearProfitList",getUserYearProfitList);
		model.addAttribute("pagination",pagination);
		model.addAttribute("profitSearch",profitSearch);
		
		return "user/myPage/myProfitListYear";
	}
 	
	
	@GetMapping("/myExperience")
	public String myExperience(Model model) {
		model.addAttribute("title","나의 경험치");
		return "user/myPage/myExperience";
	}
}
