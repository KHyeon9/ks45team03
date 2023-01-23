package ks45team03.rentravel.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.mapper.ReportMapper;
import ks45team03.rentravel.user.service.ReportService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ReportController {

	private final ReportService reportService;
	private final ReportMapper reportMapper;
	
	private static final Logger log = LoggerFactory.getLogger(ReportController.class);

	
	@PostMapping("/reportGoods")
	public String reportGoods(@RequestParam(value="goodsCode") String goodsCode
							 ,@RequestParam(value="userId") String userId
							 ,@RequestParam(value="reportTypeCode") String reportTypeCode
							 ,HttpSession session
							 ,HttpServletRequest request) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		reportService.reportGoodsList(goodsCode, reportTypeCode, userId, loginInfo.getLoginId());
		
		String referer = request.getHeader("Referer");
		
		return "redirect:"+ referer;
	}
	
	@ResponseBody
	@GetMapping("/reportGoodsAjax")
	public int reportGoodsAjax(@RequestParam(value="goodsCode") String goodsCode
							  ,HttpSession session) {
		log.info("goodsCode -->", goodsCode);
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		int reportGoodsAjax = reportMapper.reportGoodsAjax(goodsCode, loginInfo.getLoginId());
		
		return reportGoodsAjax;
	}
}