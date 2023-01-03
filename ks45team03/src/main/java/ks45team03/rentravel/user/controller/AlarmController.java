package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.dto.AlarmWish;
import ks45team03.rentravel.mapper.AlarmMapper;
import ks45team03.rentravel.user.service.AlarmService;

@Controller
@RequestMapping("/myPage")
public class AlarmController {
	
	private final AlarmService alarmService;
	private final AlarmMapper alarmMapper;
	
	public AlarmController(AlarmService alarmService, AlarmMapper alarmMapper) {
		this.alarmService = alarmService;
		this.alarmMapper = alarmMapper;
	}
	
	@GetMapping("/alarmList")
	public String getAlarmWishList(Model model) {
		List<AlarmWish> alarmWishList = alarmService.getAlarmWishList();
		
		model.addAttribute("title", "알림목록");
		model.addAttribute("alarmWishList", alarmWishList);
		
		return "user/myPage/alarmList";
	}
	
	
}