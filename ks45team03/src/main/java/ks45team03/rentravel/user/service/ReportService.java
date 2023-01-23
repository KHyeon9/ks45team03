package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.ReportGoods;
import ks45team03.rentravel.dto.ReportState;
import ks45team03.rentravel.dto.ReportType;
import ks45team03.rentravel.mapper.ReportMapper;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ReportService {

	private final ReportMapper reportMapper;
	
	public List<ReportGoods> reportGoodsList(String goodsCode, String reportTypeCode, String userId, String loginId){
		return reportMapper.reportGoodsList(goodsCode, reportTypeCode, userId, loginId);
		
	}
}
