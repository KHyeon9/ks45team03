package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Review;

@Mapper
public interface ReviewMapper {
	
	public List<Review> getReviewList(String goodsCode, int startIndex, int pageSize);
	
	public int addReview(Review review);
	
	public int modifyReview(Review review);
	
	public int removeReview(String reviewCode);
	
	public int checkReviewCount(String goodsCode, String loginId);
	
	public int checkTradeStatus(String goodsCode, String loginId);
	
	public int getReviewListCount(String goodsCode);
	
	public List<Review> getMyReviewList(String loginId, int startIndex, int pageSize);
	
	public int getMyReviewListCount(String loginId);
	
	public Review getReviewContentByReviewCode(String reviewCode);
}
