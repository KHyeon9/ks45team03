package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.GoodsImg;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.Review;
import ks45team03.rentravel.dto.Search;
import ks45team03.rentravel.mapper.UserBlockMapper;
import ks45team03.rentravel.user.service.GoodsService;
import ks45team03.rentravel.user.service.ReviewService;
import ks45team03.rentravel.user.service.WishService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {
	
	private final GoodsService goodsService;
	private final WishService wishService;

	private final UserBlockMapper userBlockMapper;

	private final ReviewService reviewService;

	
	@GetMapping("/goodsList")
	public String goodsList(Model model
							,HttpSession session
							,@RequestParam(defaultValue="1", required=false) int curPage
							,@RequestParam(defaultValue="all", required = false) String goodsCategoryCode
							,@RequestParam(value="searchKey", required = false, defaultValue = "") String searchKey
							,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue
							,@RequestParam(value="goodsRentalAvailability", required = false, defaultValue = "") String goodsRentalAvailability) {
		
		int goodsListCount = goodsService.getGoodsListCount(goodsCategoryCode, searchKey, searchValue,goodsRentalAvailability);
		Pagination pagination = new Pagination(goodsListCount, curPage,goodsCategoryCode);
		Search search = new Search(searchKey, searchValue);
		
		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();
		
		List<Goods> goodsCategoryAndCount = goodsService.getGoodsCategoryAndCount();
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		Search searchResult = new Search(searchKey, searchValue);
		
		if(loginUser == null) {
			
			List<Goods> goodsList = goodsService.getGoodsListNotLogin(startIndex, pageSize,goodsCategoryCode,searchKey,searchValue,goodsRentalAvailability);
			model.addAttribute("goodsList", goodsList);
			model.addAttribute("search",search);
			model.addAttribute("pagination", pagination);
			model.addAttribute("searchResult", searchResult);
			model.addAttribute("goodsCategoryAndCount", goodsCategoryAndCount);
			model.addAttribute("title", "상품 리스트 화면");
			
		}else {
			
			List<Goods> goodsList = goodsService.getGoodsList(loginUser.getLoginId(), startIndex,pageSize, goodsCategoryCode,searchKey,searchValue, goodsRentalAvailability);
			model.addAttribute("goodsList", goodsList);
			model.addAttribute("search",search);
			model.addAttribute("pagination", pagination);
			model.addAttribute("searchResult", searchResult);
			model.addAttribute("goodsCategoryAndCount", goodsCategoryAndCount);
			model.addAttribute("title", "상품 리스트 화면");
		
		}
		
		return "user/goods/goodsList";
	}
	
	
	
	@GetMapping("/goodsDetail")
	public String goodsDetail(Model model
							 ,@RequestParam(value="goodsCode") String goodsCode
							 ,@RequestParam(value="userId") String userId
							 ,@RequestParam(defaultValue="1", required=false) int curPage
							 ,HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String loginId =null;
		
		boolean equalIdFlag = true;
		
		if(loginUser != null) {
			loginId = loginUser.getLoginId();
			if (loginId.equals(userId)) {
				equalIdFlag = false;
			}
		}
		
		int checkWish = wishService.checkWish(goodsCode, loginId);
		
		List<GoodsImg> goodsImg = goodsService.getGoodsImg(goodsCode);
		Goods goodsDetail = goodsService.getGoodsDetailByGoodsCode(goodsCode);
		
		
		
		List<Goods> goodsListByUserId = goodsService.getGoodsListByUserId(userId,goodsCode);

		int userBlockedIdCnt = userBlockMapper.userBlockListCnt(userId, loginId);
		
		int checkReviewCount = reviewService.checkReviewCount(goodsCode, loginId);
		
		int checkTradeStatus = reviewService.checkTradeStatus(goodsCode, loginId);
		
		int reviewListCount = reviewService.getReviewListCount(goodsCode);
		
		Pagination pagination = new Pagination(reviewListCount, curPage);
		
		int startIndex = pagination.getStartIndex();
		int pageSize = pagination.getPageSize();
		
		List<Review> reviewList = reviewService.getReviewList(goodsCode, startIndex, pageSize);
		
		
		
		model.addAttribute("goodsImgs",goodsImg);
		model.addAttribute("checkReviewCount",checkReviewCount);
		model.addAttribute("checkTradeStatus",checkTradeStatus);
		model.addAttribute("pagination",pagination);
		model.addAttribute("goodsDetail",goodsDetail);
		model.addAttribute("checkWish",checkWish);
		model.addAttribute("goodsListByUserId",goodsListByUserId);

		model.addAttribute("userBlockedIdCnt",userBlockedIdCnt);

		model.addAttribute("reviewList",reviewList);
		
		model.addAttribute("equalIdFlag",equalIdFlag);
		
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
		String goodsCode = goods.getGoodsCode();
		String userId = goods.getUserId();
		
		return "redirect:/goods/goodsDetail?userId="+userId+"&goodsCode="+goodsCode;
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
	
	@PostMapping("/removeGoods")
	public String removeGoods(@RequestParam(value="goodsCode") String goodsCode) {
		
		goodsService.removeGoods(goodsCode);
		
		return "redirect:/goods/goodsList";
	}
}
