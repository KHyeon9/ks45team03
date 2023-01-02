package ks45team03.rentravel.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.GoodsImg;
import ks45team03.rentravel.user.service.GoodsService;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);

	private final GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
			this.goodsService = goodsService;
}
	
	@GetMapping("/goodsList")
	public String goodsList(Model model) {
		List<Goods> goodsList = goodsService.getGoodsList();
		
		log.info("상품목록: {}",goodsList);
		
		model.addAttribute("goodsList",goodsList);
		model.addAttribute("title", "상품 리스트 화면");
		
		return "user/goods/goodsList";
	}
	
	@GetMapping("/goodsDetail")
	public String goodsDetail(Model model
							 ,@RequestParam(value="goodsCode") String goodsCode) {
		
		List<GoodsImg> goodsImg = goodsService.getGoodsImg(goodsCode);
		Goods goodsDetail = goodsService.getGoodsDetailByGoodsCode(goodsCode);
		
		model.addAttribute("goodsImgs",goodsImg);
		model.addAttribute("goodsDetail",goodsDetail);
		model.addAttribute("title","상품 상세 정보 화면");
		
		return "user/goods/goodsDetail";
	}
	
	@GetMapping("/modifyGoods")
	public String modifyGoods(Model model
							 ,@RequestParam(value="goodsCode") String goodsCode) {
		
		Goods goodsDetail = goodsService.getGoodsDetailByGoodsCode(goodsCode);
		
		model.addAttribute("goodsDetail",goodsDetail);
		model.addAttribute("title","상품 상세 정보 화면");
		return "user/goods/modifyGoods";
	}

	@PostMapping("/modifyGoods")
	public String modifyGoods(Goods goods) {
		
		goodsService.modifyGoods(goods);
		
		return "redirect:/goods/goodsList";
	}
	
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		model.addAttribute("title","상품 상세 정보 화면");
		return "user/goods/addGoods";
	}
	
	@PostMapping("/addGoods")
	public String addGoods(Goods goods) {
		
		goodsService.addGoods(goods);
		
		return "redirect:/goods/goodsList";
	}
}
