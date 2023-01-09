package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.ReportComment;
import ks45team03.rentravel.dto.ReportGoods;
import ks45team03.rentravel.dto.ReportInfoBoard;
import ks45team03.rentravel.dto.ReportReview;
import ks45team03.rentravel.mapper.AdminReportMapper;

@Service
@Transactional
public class AdminReportService {
	private final AdminReportMapper adminReportMapper;
	
	public AdminReportService(AdminReportMapper adminReportMapper) {
		this.adminReportMapper = adminReportMapper;
	}
	
	public List<ReportComment> adminGetReportCommentList(){
		List<ReportComment> reportCommentList = adminReportMapper.adminGetReportCommentList();
		return reportCommentList;
	}
	
	public List<ReportGoods> adminGetReportGoodsList(){
		List<ReportGoods> reportGoodsList = adminReportMapper.adminGetReportGoodsList();
		return reportGoodsList;
	}
	
	public List<ReportInfoBoard> adminGetReportInfoBoardList(){
		List<ReportInfoBoard> reportInfoBoardList = adminReportMapper.adminGetReportInfoBoardList();
		return reportInfoBoardList;
	}
	
	public List<ReportReview> adminGetReportReviewList(){
		List<ReportReview> reportReviewList = adminReportMapper.adminGetReportReviewList();
		return reportReviewList;
	}
	
}
