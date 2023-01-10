package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.admin.service.AdminGoodsService;
import ks45team03.rentravel.dto.Goods;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/goods")
public class AdminGoodsController {
	
	private final AdminGoodsService adminGoodsService;
	
	@GetMapping("/adminGoodsList")
	public String adminGoodsList(Model model) {
		
		List<Goods> adminGoodsList = adminGoodsService.getAdminGoodsList();
		
		model.addAttribute("adminGoodsList",adminGoodsList);
		model.addAttribute("title","관리자 상품 관리 화면");
		
		return "admin/goods/adminGoodsList";
	}
	
	@PostMapping("/adminRemoveGoods")
	public String adminRemoveGoods(String goodsCode) {
		
		adminGoodsService.adminRemoveGoods(goodsCode);
		
		return "redirect:/admin/goods/adminGoodsList";
	}
}
