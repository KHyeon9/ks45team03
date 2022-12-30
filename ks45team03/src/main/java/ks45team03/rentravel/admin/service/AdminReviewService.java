package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Review;
import ks45team03.rentravel.mapper.AdminReviewMapper;

@Service
public class AdminReviewService {
	
	private final AdminReviewMapper adminReviewMapper;
	
	public AdminReviewService(AdminReviewMapper adminReviewMapper) {
		this.adminReviewMapper = adminReviewMapper;
	}
	
	public List<Review> getAdminReviewList(){
		
		List<Review> adminReviewList = adminReviewMapper.getAdminReviewList();
		
		return adminReviewList;
	}
}
