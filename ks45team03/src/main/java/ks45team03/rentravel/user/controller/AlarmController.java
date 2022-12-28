package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alarm")
public class AlarmController {

	@GetMapping("/alarmList")
	public String getAlarmList(Model model) {
		model.addAttribute("title", "회원 알림 목록");
		
		return "/user/alarm/alarmList";
		
	}
}
