package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/commisionRate")
public class AdminCommisionRateController {
	
	@GetMapping("/adminCommisionRateList")
	public String adminGetCommisionRateList (Model model) {
		
		model.addAttribute("title","플랫폼 수수료율 목록");
		
		return "admin/commisionRate/adminCommisionRateList";
	}
	
	
	@GetMapping("/adminAddCommisionRate")
	public String adminAddCommisionRate (Model model) {
		
		model.addAttribute("title","플랫폼 수수료율 추가");
		
		return "admin/commisionRate/adminAddCommisionRate";
	}

}



