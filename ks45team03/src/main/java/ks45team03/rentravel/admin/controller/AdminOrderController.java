package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {
	
	@GetMapping("/adminOrderHistory")
	public String adminOrderHistory(Model model) {
		model.addAttribute("title","관리자 주문 내역");
		return "admin/order/adminOrderHistory";
	}
	
	@GetMapping("/adminOrderModify")
	public String adminOrderModify(Model model) {
		model.addAttribute("title","관리자 주문 수정");
		return "admin/order/adminOrderModify";
	}
	
	@GetMapping("/adminWaybillList")
	public String adminWaybillList(Model model) {
		model.addAttribute("title","관리자 운송 번호 리스트");
		return "admin/order/adminWaybillList";
	}
	
	@GetMapping("/adminWaybillModify")
	public String adminWaybillModify(Model model) {
		model.addAttribute("title","관리자 운송 번호 수정");
		return "admin/order/adminWaybillModify";
	}
	// 
	@GetMapping("/adminRentalcancelList")
	public String adminRentalcancelList(Model model) {
		model.addAttribute("title","관리자 주문 취소 리스트");
		return "admin/order/adminRentalcancelList";
	}
	
	@GetMapping("/adminRentalcancelModify")
	public String adminRentalcancelModify(Model model) {
		model.addAttribute("title","관리자 주문 취소 수정");
		return "admin/order/adminRentalcancelModify";
	}
	
	@GetMapping("/adminReturnList")
	public String adminReturnList(Model model) {
		model.addAttribute("title","관리자 환불 리스트");
		return "admin/order/adminReturnList";
	}
	
	@GetMapping("/adminReturnModify")
	public String adminReturnModify(Model model) {
		model.addAttribute("title","관리자 환불 수정");
		return "admin/order/adminReturnModify";
	}
}
