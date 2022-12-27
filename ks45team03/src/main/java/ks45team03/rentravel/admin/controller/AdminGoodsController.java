package ks45team03.rentravel.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {
	
	@GetMapping("/adminGoodsList")
	public String adminGoodsList(Model model) {
		model.addAttribute("title","관리자 상품 관리 화면");
		return "admin/goods/adminGoodsList";
	}
}
