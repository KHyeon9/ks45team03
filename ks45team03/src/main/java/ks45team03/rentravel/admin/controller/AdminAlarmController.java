package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/alarm")
public class AdminAlarmController {

	@GetMapping("/adminAlarmList")
	public String adminGetAlarmList(Model model) {
		model.addAttribute("title", "관리자 알림 내용 목록");
		
		return "/admin/alarm/adminAlarmList";
	}
	
	@GetMapping("/adminModifyAlarm")
	public String adminModifyAlarm(Model model) {
		model.addAttribute("title", "관리자 알림 내용 수정");
		
		return "/admin/alarm/adminModifyAlarm";
	}
}
