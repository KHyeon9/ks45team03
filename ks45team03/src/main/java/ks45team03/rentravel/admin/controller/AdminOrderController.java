package ks45team03.rentravel.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.admin.service.AdminOrderService;
import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.RentalCancel;
import ks45team03.rentravel.dto.Return;
import ks45team03.rentravel.dto.WaybillOwner;
import ks45team03.rentravel.dto.WaybillRenter;
import ks45team03.rentravel.mapper.AdminOrderMapper;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {
	
	private final AdminOrderService adminOrderService;
	private final AdminOrderMapper adminOrderMapper;
	
	public AdminOrderController(AdminOrderService adminOrderService, AdminOrderMapper adminOrderMapper) {
		this.adminOrderService = adminOrderService;
		this.adminOrderMapper = adminOrderMapper;
	}
	
	// 주문 내역 리스트 조회
	@GetMapping("/adminOrderHistory")
	public String adminOrderHistory(@RequestParam(value="curPage", defaultValue="1", required=false) int curPage, 
									Model model) {
		
		int listCnt = adminOrderMapper.getOrderHistoryCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		List<Rental> orderHistory = adminOrderMapper.getOrderHistory(pagination.getStartIndex(), pagination.getPageSize());
		
		model.addAttribute("title","관리자 주문 내역");
		model.addAttribute("pagination", pagination);
		model.addAttribute("orderHistory", orderHistory);
		
		return "admin/order/adminOrderHistory";
	}
	
	// 관리자 주문 수정 액션
	@PostMapping("/adminOrderModify")
	public String adminOrderModify(Rental rentalInfo) {
		
		adminOrderService.modifyOrderInfo(rentalInfo);
		
		return "redirect:/admin/order/adminOrderHistory";
	}
	
	// 관리자 주문 수정 폼 정보 조회
	@GetMapping("/adminOrderModify")
	public String adminOrderModify(@RequestParam(value = "rentalCode") String rentalCode,
									Model model) {
		System.out.println(rentalCode);
		
		Rental orderInfo = adminOrderMapper.getOrderInfoByRentalCode(rentalCode);
		
		model.addAttribute("title","관리자 주문 수정");
		model.addAttribute("orderInfo", orderInfo);
		return "admin/order/adminOrderModify";
	}
	
	// 운송장 번호 목록 조회
	@GetMapping("/adminWaybillHistory")
	public String adminWaybillHistory(@RequestParam(value="ownerCurPage", defaultValue="1", required=false) int ownerCurPage,
			 					   @RequestParam(value="renterCurPage", defaultValue="1", required=false) int renterCurPage,
								   Model model) {
		int ownerWaybillCnt = adminOrderMapper.getOwnerWaybillCnt();
		int renterWaybillCnt = adminOrderMapper.getRenterWaybillCnt();
		
		Pagination paginationOwner = new Pagination(ownerWaybillCnt, ownerCurPage);
		Pagination paginationRenter = new Pagination(renterWaybillCnt, renterCurPage);
		
		model.addAttribute("title","관리자 운송 번호 리스트");
		List<WaybillOwner> waybillOwnerList = adminOrderService.getWaybillOwners(paginationOwner.getStartIndex(), paginationOwner.getPageSize());
		List<WaybillRenter> waybillRenterList = adminOrderService.getWaybillRenters(paginationRenter.getStartIndex(), paginationRenter.getPageSize());
		
		model.addAttribute("waybillOwnerList", waybillOwnerList);
		model.addAttribute("waybillRenterList", waybillRenterList);
		model.addAttribute("paginationOwner", paginationOwner);
		model.addAttribute("paginationRenter", paginationRenter);
		
		return "admin/order/adminWaybillHistory";
	}
	
	// 오너 운송장 번호 수정 post
	@PostMapping("/adminWaybillModifyOwner")
	public String adminWaybillModifyOwner(WaybillOwner waybillOwner,
										  Model model) {
		
		adminOrderMapper.modifyWaybillOwner(waybillOwner);
		
		return "redirect:/admin/order/adminWaybillHistory";
	}
	
	// 오너 운송장 번호 수정 get
	@GetMapping("/adminWaybillModifyOwner")
	public String adminWaybillModifyOwner(@RequestParam(value = "waybillOwnerCode") String waybillOwnerCode,
										  Model model) {
		WaybillOwner waybillOwner = adminOrderMapper.getOwnerWayBill(waybillOwnerCode);
		
		model.addAttribute("title","관리자 오너 운송 번호 수정");
		model.addAttribute("waybillOwner", waybillOwner);
		
		
		return "admin/order/adminWaybillModifyOwner";
	}
	
	// 렌터 운송장 번호 수정 post
	@PostMapping("/adminWaybillModifyRenter")
	public String adminWaybillModifyRenter(WaybillRenter waybillRenter,
										   Model model) {
		
		adminOrderMapper.modifyWaybillRenter(waybillRenter);
		
		return "redirect:/admin/order/adminWaybillHistory";
	}
	
	// 렌터 운송장 번호 수정 get
	@GetMapping("/adminWaybillModifyRenter")
	public String adminWaybillModifyRenter(@RequestParam(value = "waybillRenterCode", required = false) String waybillRenterCode,
										   Model model) {
		WaybillRenter waybillRenter = adminOrderMapper.getRenterWayBill(waybillRenterCode);
		
		model.addAttribute("title","관리자 렌터 운송 번호 수정");
		model.addAttribute("waybillRenter", waybillRenter);
		
		return "admin/order/adminWaybillModifyRenter";
	}
	
	// 주문 취소 내역 조회 
	@GetMapping("/adminRentalcancelHistory")
	public String adminRentalcancelHistory(@RequestParam(value="curPage", defaultValue="1", required=false) int curPage,
										   Model model) {
		
		int listCnt = adminOrderMapper.getRentalCancelHistoryCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		List<RentalCancel> rentalCancelHistory = adminOrderMapper.getRentalCancelHistory(pagination.getStartIndex(), pagination.getPageSize());
		
		model.addAttribute("title","관리자 주문 취소 리스트");
		model.addAttribute("pagination", pagination);
		model.addAttribute("rentalCancelHistory", rentalCancelHistory);
		
		return "admin/order/adminRentalcancelHistory";
	}
	
	@GetMapping("/adminRentalcancelModify")
	public String adminRentalcancelModify(Model model) {
		model.addAttribute("title","관리자 주문 취소 수정");
		return "admin/order/adminRentalcancelModify";
	}
	
	@GetMapping("/adminReturnHistory")
	public String adminReturnHistory(@RequestParam(value="curPage", defaultValue="1", required=false) int curPage,
								      Model model) {
		
		int listCnt = adminOrderMapper.getRentalCancelHistoryCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		List<Return> returnHistory = adminOrderMapper.getReturnHistory(pagination.getStartIndex(), pagination.getPageSize());
		
		model.addAttribute("title","관리자 환불 리스트");
		model.addAttribute("pagination", pagination);
		model.addAttribute("returnHistory", returnHistory);;
		
		return "admin/order/adminReturnHistory";
	}
	
	@GetMapping("/adminReturnModify")
	public String adminReturnModify(Model model) {
		model.addAttribute("title","관리자 환불 수정");
		
		return "admin/order/adminReturnModify";
	}
}
