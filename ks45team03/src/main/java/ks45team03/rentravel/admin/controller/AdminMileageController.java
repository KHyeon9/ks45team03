package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.admin.service.AdminMileageService;
import ks45team03.rentravel.dto.MileagePaymentSave;
import ks45team03.rentravel.dto.MileageRentalCancelSave;
import ks45team03.rentravel.dto.MileageSaveUse;
import ks45team03.rentravel.mapper.AdminMileageMapper;

@Controller
@RequestMapping("/admin/mileage")
public class AdminMileageController {

	private final AdminMileageService adminMileageService;
	private final AdminMileageMapper adminMileageMapper;

	public AdminMileageController(AdminMileageService adminMileageService, AdminMileageMapper adminMileageMapper) {
		this.adminMileageService = adminMileageService;
		this.adminMileageMapper = adminMileageMapper;
	}

	@GetMapping("/adminMileageList")
	
	public String adminGetMileageList(Model model) {
		
		List<MileageSaveUse> mileageList = adminMileageService.adminGetMileageList();
		
		model.addAttribute("title", "관리자- 결제취소 적립금 목록");
		model.addAttribute("mileageList", mileageList);
		
		return "admin/mileage/adminMileageList";
	}
	
}
