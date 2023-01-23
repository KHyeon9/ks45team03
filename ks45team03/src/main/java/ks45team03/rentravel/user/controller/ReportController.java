package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.dto.MileageSaveUse;
import ks45team03.rentravel.dto.ReportState;
import ks45team03.rentravel.dto.ReportType;
import ks45team03.rentravel.mapper.ReportMapper;
import ks45team03.rentravel.user.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {

	private final ReportService reportService;
	private final ReportMapper reportMapper;
	
	public ReportController(ReportService reportService, ReportMapper reportMapper) {
		this.reportMapper = reportMapper;
		this.reportService = reportService;
	}
	
	@GetMapping("/reportTest")
	public String test(Model model) {
		model.addAttribute("title", "신고실험");
		return "user/report/reportTest";
		
	}
	
	

	
}
