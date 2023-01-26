package ks45team03.rentravel.user.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.mapper.ReportMapper;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ReportService {

	private final ReportMapper reportMapper;
	
	public void reportGoodsList(String goodsCode, String reportTypeCode, String userId, String loginId){
		reportMapper.reportGoodsList(goodsCode, reportTypeCode, userId, loginId);
	}
	
	public void reportReviewList(String reviewCode, String reportTypeCode, String userId, String loginId){
		reportMapper.reportReviewList(reviewCode, reportTypeCode, userId, loginId);
	}
}
