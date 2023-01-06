package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.UserMapper;
import ks45team03.rentravel.user.service.GoodsService;
import ks45team03.rentravel.user.service.InfoBoardService;
import ks45team03.rentravel.user.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/order")
@AllArgsConstructor
@Slf4j
public class OrderController {
	
	private OrderService orderService;
	private GoodsService goodsService;
	
	@GetMapping("/paymentResult")
	public String paymentResult(Model model) {
		model.addAttribute("title","결제완료");
		
		return "user/order/paymentResult";
	}
	
	
	
	@PostMapping("/payment")
	public String payment(Rental rental, Model model) {
		log.info("{}", rental);
		
		return "redirect:/order/paymentResult";
	}
	
	@GetMapping("/payment")
	public String payment(@RequestParam(value = "goodsCode", required = false) String goodsCode,
						  @RequestParam(value = "selectDelivery", required = false) String selectDelivery,
						  @RequestParam(value = "rentalStartDate", required = false) String rentalStartDate,
						  @RequestParam(value = "rentalEndDate", required = false) String rentalEndDate,
						  Model model) {
		Goods goods = goodsService.getGoodsDetailByGoodsCode(goodsCode);
		
		model.addAttribute("title", "결제 화면");
		model.addAttribute("goods", goods);
		model.addAttribute("selectDelivery", selectDelivery);
		model.addAttribute("rentalStartDate", rentalStartDate);
		model.addAttribute("rentalEndDate", rentalEndDate);
		
		return "user/order/payment";
	}
	
	@GetMapping("/waybill")
	public String addWaybill(Model model) {
		model.addAttribute("title", "운송장 번호 입력");
		
		return "user/order/waybill";
	}
}