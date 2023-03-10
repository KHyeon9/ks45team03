package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Review;

@Mapper
public interface AdminReviewMapper {
	
	public List<Review> getAdminReviewList();
	
	public int removeAdminReview(String reviewCode);
	
	public int removeAdminReviewMileage(String reviewCode);
	
	public int removeAdminReviewReport(String reviewCode);
}
