package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@PostMapping("/addReview")
	public void addReview(@RequestBody Review review) {
		
		
		String reviewCode = commonNewCode.getCommonNewCode("tb_review", "review_code");
		review.setReviewCode(reviewCode);
		
		reviewService.addReview(review);
		
	}
	
	@PostMapping("/modifyReview")
	@ResponseBody
	public void modifyReview(@RequestBody Review review) {
		
		reviewService.modifyReview(review);
	}
	
	@ResponseBody
	@PostMapping("/removeReview")
	public void removeReview(@RequestBody String reviewCode) {
		
		reviewService.removeReview(reviewCode);
	}
	
}
