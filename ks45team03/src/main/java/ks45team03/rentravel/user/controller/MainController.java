package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user/myPage")
public class MainController {
	
	@GetMapping("/getUserBlockrList")
	public String main(Model model) {
		model.addAttribute("title", "메인화면");
		return "user/myPage/myBlockList";
	}
}
