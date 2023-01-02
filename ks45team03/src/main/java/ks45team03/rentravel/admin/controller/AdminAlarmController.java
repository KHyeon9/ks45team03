package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.admin.service.AdminAlarmService;
import ks45team03.rentravel.dto.AlarmWish;
import ks45team03.rentravel.mapper.AdminAlarmMapper;

@Controller
@RequestMapping("/admin/alarm")
public class AdminAlarmController {
	
	private final AdminAlarmService adminAlarmService;
	private final AdminAlarmMapper adminAlarmMapper;
	
	public AdminAlarmController(AdminAlarmService adminAlarmService, AdminAlarmMapper adminAlarmMapper) {
		this.adminAlarmService = adminAlarmService;
		this.adminAlarmMapper = adminAlarmMapper;
	}
	
	@GetMapping("/adminAlarmList")
	public String adminGetAlarmWishList(Model model) {
		
		List<AlarmWish> alarmWishList = adminAlarmService.adminGetAlarmWishList();
		model.addAttribute("tittle", "관리자- 알림목록");
		model.addAttribute("alarmWishList", alarmWishList);
		
		return "admin/alarm/adminAlarmList";
	}
}
