package ks45team03.rentravel.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.admin.service.AdminCommisionRateService;
import ks45team03.rentravel.dto.CommisionRate;

@Controller
@RequestMapping("/admin/commisionRate")
public class AdminCommisionRateController {
	
	private final AdminCommisionRateService adminCommisionRateService;
	
	public AdminCommisionRateController (AdminCommisionRateService adminCommisionRateService) {
		this.adminCommisionRateService = adminCommisionRateService;		
	}
	
	
	//플랫폼 수수료율 수정
	@PostMapping("/adminModifyCommisionRate")
	public String adminModifyCommisionRate (CommisionRate commisionRate) {
		
		adminCommisionRateService.adminModifyCommisionRate(commisionRate);
		
		return "redirect:/admin/commisionRate/adminCommisionRateList";
	}
	
	
	//플랫폼 수수료율 수정
	@GetMapping("/adminModifyCommisionRate")
	public String adminModifyCommisionRate (Model model
											,@RequestParam(value = "commisionRateCode", required = false) String commisionRateCode) {
		
		CommisionRate commisionRateInfo = adminCommisionRateService.adminGetCommisionRateListByCode(commisionRateCode);
		
		model.addAttribute("title","플랫폼 수수료율 수정");
		model.addAttribute("commisionRateInfo",commisionRateInfo);
		
		return "admin/commisionRate/adminModifyCommisionRate";
	}
	
	
	//플랫폼 수수료율 추가
	@PostMapping("/adminAddCommisionRate")
	public String adminAddCommisionRate (CommisionRate commisionRate) {
		
		adminCommisionRateService.adminAddCommisionRate(commisionRate);
		
		return "redirect:/admin/commisionRate/adminCommisionRateList";
	}
	
	
	//플랫폼 수수료율 추가
	@GetMapping("/adminAddCommisionRate")
	public String adminAddCommisionRate (Model model) {
		
		model.addAttribute("title","플랫폼 수수료율 추가");
	
		return "admin/commisionRate/adminAddCommisionRate";
	}

	
	// 플랫폼 수수료율 목록
	@GetMapping("/adminCommisionRateList")
	public String adminGetCommisionRateList (Model model) {
		
		List<CommisionRate> adminGetCommisionRateList = adminCommisionRateService.adminGetCommisionRateList();
		
		
		
		model.addAttribute("title","플랫폼 수수료율 목록");
		model.addAttribute("adminGetCommisionRateList",adminGetCommisionRateList);
		
		return "admin/commisionRate/adminCommisionRateList";
	}
	

}



