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
	
	public List<ReportGoods> reportGoodsList(String goodsCode, String reportTypeCode, String userId, String loginId);
}
