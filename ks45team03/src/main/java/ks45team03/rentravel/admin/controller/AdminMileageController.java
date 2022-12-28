package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/mileage")
public class AdminMileageController {
	
	@GetMapping("/adminMileageList")
	public String adminGetMileageList(Model model) {
		model.addAttribute("title", "관리자 적립금 목록");
	
		return "/admin/mileage/adminMileageList";
	}

}
