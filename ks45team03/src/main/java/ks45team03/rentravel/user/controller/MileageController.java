package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPage")
public class MileageController {
	
	
	
	@GetMapping("/myMileageList")
	public String getMyMileageList(Model model) {
		model.addAttribute("title", "적립금 적립/사용 내역");

		return "/user/myPage/myMileageList";
	}

	
	
}
