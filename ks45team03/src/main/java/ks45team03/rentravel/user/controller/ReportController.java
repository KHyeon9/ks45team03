package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.ReportGoods;
import ks45team03.rentravel.user.service.ReportService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ReportController {

	private final ReportService reportService;
	
	@PostMapping("/goodsDetail")
	public List<ReportGoods> reportGoods(@RequestParam(value="goodsCode") String goodsCode
							 ,@RequestParam(value="userId") String userId
							 ,@RequestParam(value="reportTypeCode") String reportTypeCode
							 ,HttpSession session) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		List<ReportGoods> reportGoodsList = reportService.reportGoodsList(goodsCode, reportTypeCode, userId, loginInfo.getLoginId());
		
		return reportGoodsList;
	}
}