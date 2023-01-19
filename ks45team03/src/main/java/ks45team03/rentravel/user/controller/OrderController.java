package ks45team03.rentravel.user.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.RegionSgg;
import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.OrderMapper;
import ks45team03.rentravel.user.service.GoodsService;
import ks45team03.rentravel.user.service.OrderService;
import ks45team03.rentravel.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/order")
@AllArgsConstructor
@Slf4j
public class OrderController {
	
	private OrderService orderService;
	private OrderMapper orderMapper;
	private GoodsService goodsService;
	private UserService userService;
	private CommonNewCode commonNewCode;
	
	// 마일리지 사용량 초과 검사
	@ResponseBody
	@PostMapping("/checkMileage")
	public boolean checkMileage(@RequestBody int useMileage, HttpSession session) {
		boolean result = false;
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		String userId = loginInfo.getLoginId();
		
		System.out.println(userId);
		
		int totalMileage = orderMapper.getUserTotalMileage(userId);
		
		if(useMileage <= totalMileage) {
			result = true;
		}
		
		return result;
	}
	
	// 결제 결과 창
	@GetMapping("/paymentResult")
	public String paymentResult(@RequestParam(value = "rentalCode") String rentalCode,
								Model model) throws ParseException {
		
		Rental rentalInfo = orderService.getRentalGoodsInfo(rentalCode);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = format.parse(rentalInfo.getRentalStartDate());
		Date endDate = format.parse(rentalInfo.getRentalEndDate());
		long dayGap = (endDate.getTime() - startDate.getTime()) /  86400000;
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String rentalStartDate = simpleDateFormat.format(startDate);
		String rentalEndDate = simpleDateFormat.format(endDate);
		
		rentalInfo.setRentalStartDate(rentalStartDate);
		rentalInfo.setRentalEndDate(rentalEndDate);
		
		log.info("{} {} ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", rentalInfo.getRentalStartDate(), rentalInfo.getRentalEndDate());
		
		model.addAttribute("title","결제완료");
		model.addAttribute("rentalInfo", rentalInfo);
		model.addAttribute("dayGap", dayGap);
		
		return "user/order/paymentResult";
	}
	
	@PostMapping("/payment")
	public String payment(Rental rental, HttpSession session) throws ParseException{
		
		String rentalCode = commonNewCode.getCommonNewCode("tb_rental", "rental_code");
		String paymentCode = commonNewCode.getCommonNewCode("tb_payment","payment_code");
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		rental.setRentalCode(rentalCode);
		rental.setUserId(loginInfo.getLoginId());
		rental.getPayment().setPaymentCode(paymentCode);
		rental.getPayment().setUserId(loginInfo.getLoginId());
		
		orderService.addOrder(rental);
		
		
		return "redirect:/order/paymentResult?rentalCode=" + rentalCode;
	}
	
	@GetMapping("/payment")
	public String payment(@RequestParam(value = "goodsCode", required = false) String goodsCode,
						  @RequestParam(value = "selectDelivery", required = false) String selectDelivery,
						  @RequestParam(value = "rentalStartDate", required = false) String rentalStartDate,
						  @RequestParam(value = "rentalEndDate", required = false) String rentalEndDate,
						  HttpServletResponse response,
						  HttpSession session,
						  Model model) throws IOException, ParseException {
		Goods goods = goodsService.getGoodsDetailByGoodsCode(goodsCode);
		log.info("goods : {}", goods);
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		if (loginInfo == null) {
			CommonController.alertPlzLogin(response);
			
			return "user/user/login";
		}
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = format.parse(rentalStartDate);
		Date endDate = format.parse(rentalEndDate);
		long dayGap = (endDate.getTime() - startDate.getTime()) /  (24*60*60*1000);
		
		User userInfo = orderMapper.loginUserInfo(loginInfo.getLoginId());
		List<RegionSido> getRegionSido = userService.getRegionSido();
		List<RegionSgg> getRegionSgg = orderMapper.getRegionSggBySidoCode(userInfo.getRegionSgg().getRegionSidoCode());
		model.addAttribute("title", "결제 화면");
		model.addAttribute("goods", goods);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("getRegionSido", getRegionSido);
		model.addAttribute("getRegionSgg", getRegionSgg);
		model.addAttribute("selectDelivery", selectDelivery);
		model.addAttribute("rentalStartDate", rentalStartDate);
		model.addAttribute("rentalEndDate", rentalEndDate);
		model.addAttribute("dayGap", dayGap);
		model.addAttribute("totalPrice", goods.getGoodsDayPrice() * dayGap);
		
		
		return "user/order/payment";
	}
	
	@GetMapping("/waybill")
	public String addWaybill(Model model) {
		model.addAttribute("title", "운송장 번호 입력");
		
		return "user/order/waybill";
	}
}