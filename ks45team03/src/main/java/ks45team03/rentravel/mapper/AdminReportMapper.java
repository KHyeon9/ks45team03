package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.ReportComment;
import ks45team03.rentravel.dto.ReportGoods;
import ks45team03.rentravel.dto.ReportInfoBoard;
import ks45team03.rentravel.dto.ReportReview;

@Mapper
public interface AdminReportMapper {
	
	public List<ReportComment> adminGetReportCommentList();
	
	public List<ReportGoods> adminGetReportGoodsList();
	
	public List<ReportInfoBoard> adminGetReportInfoBoardList();
	
	public List<ReportReview> adminGetReportReviewList();

}
