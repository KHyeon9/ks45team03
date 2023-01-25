package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.admin.service.AdminReportService;
import ks45team03.rentravel.dto.ReportComment;
import ks45team03.rentravel.dto.ReportGoods;
import ks45team03.rentravel.dto.ReportInfoBoard;
import ks45team03.rentravel.dto.ReportReview;
import ks45team03.rentravel.mapper.AdminReportMapper;

@Controller
@RequestMapping("/admin/report")
public class AdminReportController {
	
	private final AdminReportService adminReportService;
	private final AdminReportMapper adminReportMapper;
	
	public AdminReportController(AdminReportService adminReportService, AdminReportMapper adminReportMapper) {
		this.adminReportMapper = adminReportMapper;
		this.adminReportService = adminReportService;
	}
	
	@GetMapping("/adminReportList")
	public String adminGetReportList(Model model) {
		model.addAttribute("title", "관리자 신고 목록");
		List<ReportComment> reportCommentList = adminReportMapper.adminGetReportCommentList();
		List<ReportGoods> reportGoodsList = adminReportMapper.adminGetReportGoodsList();
		List<ReportInfoBoard> reportInfoBoardList = adminReportMapper.adminGetReportInfoBoardList();
		List<ReportReview> reportReviewList = adminReportMapper.adminGetReportReviewList();
		 
		model.addAttribute("reportCommentList", reportCommentList);
		model.addAttribute("reportGoodsList", reportGoodsList);
		model.addAttribute("reportInfoBoardList", reportInfoBoardList);
		model.addAttribute("reportReviewList", reportReviewList);
		
		return "admin/report/adminReportList";
	}
	
	@GetMapping("/adminReportDetail/{reportCommentCode}")
	public String adminGetReportDetail(Model model, @PathVariable(value="reportCommentCode")String reportComment) {
		model.addAttribute("title", "관리자 신고 상세");
		return "admin/report/adminReportDetail";
	}
	
	

}
