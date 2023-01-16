package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.dto.Review;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.user.service.ReviewService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/review")
public class ReviewController {
	
	private final ReviewService reviewService;
	private final CommonNewCode commonNewCode;
	
	@PostMapping("/addReview")
	public String addReview(Review review) {
		
		
		String reviewCode = commonNewCode.getCommonNewCode("tb_review", "review_code");
		review.setReviewCode(reviewCode);
		
		reviewService.addReview(review);
		
		return "redirect:/goods/goodsList";
	}
	
}
