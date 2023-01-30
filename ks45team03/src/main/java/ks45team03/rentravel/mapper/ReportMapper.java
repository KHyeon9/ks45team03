package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.ReportGoods;
import ks45team03.rentravel.dto.ReportState;
import ks45team03.rentravel.dto.ReportType;

@Mapper
public interface ReportMapper {

	public List<ReportState> getReportStateList();
	
	public List<ReportType> getReportTypeList();
	
	public int reportGoodsList(String goodsCode, String reportTypeCode, String userId, String loginId);
	
	public int reportGoodsAjax(String goodsCode, String loginId);
	
	public int reportReviewList(String reviewCode, String reportTypeCode, String userId, String loginId);
	
	public int reportReviewAjax(String reviewCode, String loginId);
}
