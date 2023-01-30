package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.user.service.GoodsService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	
	private final GoodsService goodsService;

	@GetMapping("/")
	public String main(Model model) {
		
		List<Goods> mainGoodsList = goodsService.getMainGoodsList();
		
		model.addAttribute("title", "RENTravel");
		model.addAttribute("mainGoodsList", mainGoodsList);
		
		return "user/main";
	}
}
