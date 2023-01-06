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
	
	//주문 내역 리스트 조회
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
	@GetMapping("/adminWaybillList")
	public String adminWaybillList(@RequestParam(value="ownerCurPage", defaultValue="1", required=false) int ownerCurPage,
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
		
		return "admin/order/adminWaybillList";
	}
	
	// 오너 운송장 번호 수정 post
	@PostMapping("/adminWaybillModifyOwner")
	public String adminWaybillModifyOwner(WaybillOwner waybillOwner,
										  Model model) {
		
		adminOrderMapper.modifyWaybillOwner(waybillOwner);
		
		return "redirect:/admin/order/adminWaybillList";
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
		
		return "redirect:/admin/order/adminWaybillList";
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
	@SuppressWarnings("unchecked")
	@GetMapping("/adminRentalcancelList")
	public String adminRentalcancelList(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
										Model model) {
		Map<String, Object> paramMap = adminOrderService.getRentalCancelHistory(currentPage);
		
		List<RentalCancel> rentalCancelHistory =  (List<RentalCancel>) paramMap.get("rentalCancelHistory");
		
		int lastPage = (int) paramMap.get("lastPage");
		int startPageNum = (int) paramMap.get("startPageNum");
		int endPageNum = (int) paramMap.get("endPageNum");
		int nextPage = (int) paramMap.get("nextPage");
		int prevPage = (int) paramMap.get("prevPage");
		
		model.addAttribute("title","관리자 주문 취소 리스트");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rentalCancelHistory", rentalCancelHistory);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("prevPage", prevPage);
		
		return "admin/order/adminRentalcancelList";
	}
	
	@GetMapping("/adminRentalcancelModify")
	public String adminRentalcancelModify(Model model) {
		model.addAttribute("title","관리자 주문 취소 수정");
		return "admin/order/adminRentalcancelModify";
	}
	
	@GetMapping("/adminReturnList")
	public String adminReturnList(Model model) {
		
		List<Return> returnList = adminOrderService.getReturnList();
		
		model.addAttribute("title","관리자 환불 리스트");
		model.addAttribute("returnList", returnList);
		
		return "admin/order/adminReturnList";
	}
	
	@GetMapping("/adminReturnModify")
	public String adminReturnModify(@RequestParam(value="rentalCode") String rentalCode, 
									Model model) {
		model.addAttribute("title","관리자 환불 수정");
		
		return "admin/order/adminReturnModify";
	}
}
