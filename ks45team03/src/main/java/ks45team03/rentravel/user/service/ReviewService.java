package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Review;
import ks45team03.rentravel.mapper.ReviewMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewService {
	
	private final ReviewMapper reviewMapper;
	
	public List<Review> getReviewList(String goodsCode){
		
		List<Review> reviewList = reviewMapper.getReviewList(goodsCode);
		
		return reviewList;
	}
	
	public int addReview(Review review) {
		
		return reviewMapper.addReview(review);
	}
	
	public int modifyReview(Review review) {
		
		return reviewMapper.modifyReview(review);
	}
	
	public int removeReview(String reviewCode) {
		
		return reviewMapper.removeReview(reviewCode);
	}
	
}
