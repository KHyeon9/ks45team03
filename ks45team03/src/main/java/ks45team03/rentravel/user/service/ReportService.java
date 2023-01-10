package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.ReportState;
import ks45team03.rentravel.dto.ReportType;
import ks45team03.rentravel.mapper.ReportMapper;

@Service
@Transactional
public class ReportService {

	private final ReportMapper reportMapper;
	
	public ReportService(ReportMapper reportMapper) {
	this.reportMapper = reportMapper;
	}
	
	public List<ReportState> getReportStateList(){
		List<ReportState> reportStrateList = reportMapper.getReportStateList();
		return reportStrateList;
	}
	
	public List<ReportType> getReportTypeList(){
		List<ReportType> reportTypeList = reportMapper.getReportTypeList();
		return reportTypeList;
	}
}
