package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/goods")
public class GoodsController {
	
	@GetMapping("/goodsList")
	public String goodsList(Model model) {
		model.addAttribute("title", "상품 리스트 화면");
		return "user/goods/goodsList";
	}
	
	@GetMapping("/goodsDetail")
	public String goodsDetail(Model model) {
		model.addAttribute("title","상품 상세 정보 화면");
		return "user/goods/goodsDetail";
	}
	
	@GetMapping("/modifyGoods")
	public String modifyGoods(Model model) {
		model.addAttribute("title","상품 상세 정보 화면");
		return "user/goods/modifyGoods";
	}
}
