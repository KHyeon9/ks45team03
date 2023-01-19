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
	
	@GetMapping("/adminActivateGoodsList")
	public String adminActivateGoodsList(Model model) {
		
		String goodsState = "activate";
		
		List<Goods> adminGoodsList = adminGoodsService.getAdminGoodsList(goodsState);
		
		model.addAttribute("adminGoodsList",adminGoodsList);
		model.addAttribute("title","관리자 판매중인 상품 관리");
		
		return "admin/goods/adminActivateGoodsList";
	}
	
	@GetMapping("adminDisabledGoodsList")
	public String adminDisabledGoodsList(Model model) {
		
		String goodsState = "disabled";
		
		List<Goods> adminGoodsList = adminGoodsService.getAdminGoodsList(goodsState);
		
		model.addAttribute("adminGoodsList",adminGoodsList);
		model.addAttribute("title","관리자 삭제된 상품 관리");
		
		return "admin/goods/adminDisabledGoodsList";
	}
	
	@PostMapping("/adminRemoveGoods")
	public String adminRemoveGoods(String goodsCode) {
		
		adminGoodsService.adminRemoveGoods(goodsCode);
		
		return "redirect:/admin/goods/adminGoodsList";
	}
}
