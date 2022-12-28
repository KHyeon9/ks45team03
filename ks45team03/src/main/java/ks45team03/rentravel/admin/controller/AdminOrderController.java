package ks45team03.rentravel.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.admin.service.AdminOrderService;
import ks45team03.rentravel.dto.Rental;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {
	
	private final AdminOrderService adminOrderService;
	
	public AdminOrderController(AdminOrderService adminOrderService) {
		this.adminOrderService = adminOrderService;
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/adminOrderHistory")
	public String adminOrderHistory(@RequestParam(value = "int currentPage", defaultValue = "1", required = false) int currentPage, 
									Model model) {
		
		Map<String, Object> paramMap = adminOrderService.getOrderHistory(currentPage);
		
		List<Rental> orderHistory = (List<Rental>) paramMap.get("orderHistory");
		int lastPage = (int) paramMap.get("lastPage");
		int startPageNum = (int) paramMap.get("startPageNum");
		int endPageNum = (int) paramMap.get("endPageNum");
		int nextPage = (int) paramMap.get("nextPage");
		int prevPage = (int) paramMap.get("prevPage");
		
		model.addAttribute("title","관리자 주문 내역");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("orderHistory", orderHistory);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("prevPage", prevPage);
		
		
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
