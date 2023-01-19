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
	
	public List<Review> getReviewList(String goodsCode, int startIndex, int pageSize){
		
		List<Review> reviewList = reviewMapper.getReviewList(goodsCode,startIndex,pageSize);
		
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
	
	public int checkReviewCount(String goodsCode, String loginId) {
		
		int checkReviewCount = reviewMapper.checkReviewCount(goodsCode, loginId);
		
		return checkReviewCount;
	}
	
	public int checkTradeStatus(String goodsCode, String loginId) {
		
		int checkTradeStatus = reviewMapper.checkTradeStatus(goodsCode, loginId);
		
		return checkTradeStatus;
	}
	
	public int getReviewListCount(String goodsCode) {
		
		int reviewListCount = reviewMapper.getReviewListCount(goodsCode);
		
		return reviewListCount;
	}
	
	public List<Review> getMyReviewList(String loginId, int startIndex, int pageSize){
		
		List<Review> myReviewList = reviewMapper.getMyReviewList(loginId, startIndex, pageSize);
		
		return myReviewList;
	}
	
	public int getMyReviewListCount(String loginId) {
		
		int myReviewListCount = reviewMapper.getMyReviewListCount(loginId);
		
		return myReviewListCount;
	}
	
	public Review getReviewContentByReviewCode(String ReviewCode) {
		
		Review reviewContent = reviewMapper.getReviewContentByReviewCode(ReviewCode);
		
		return reviewContent;
	}
}
