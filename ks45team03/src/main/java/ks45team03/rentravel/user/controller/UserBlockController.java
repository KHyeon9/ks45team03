package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/block")
public class UserBlockController {

	@GetMapping("/removeBlock")
	public String removeUserBlock (Model model) {
		model.addAttribute("title","회원 아이디 차단 삭제");
		return "user/block/removeBlock";
	}
}
