package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Review;

@Mapper
public interface ReviewMapper {
	
	public List<Review> getReviewList(String goodsCode);
	
	public int addReview(Review review);
	
	public int modifyReview(Review review);
	
	public int removeReview(String reviewCode);
	
}
