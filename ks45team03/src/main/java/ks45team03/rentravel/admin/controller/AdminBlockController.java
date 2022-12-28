package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/block")
public class AdminBlockController {

	@GetMapping("/adminBlockList")
	public String adminGetUserBlockrList(Model model) {
		
		model.addAttribute("title","관리자 회원 아이디 차단 목록");
		return "admin/block/adminBlockList";
	}
}
