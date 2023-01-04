package ks45team03.rentravel.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsurancePayout;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.mapper.InsuranceMapper;
import ks45team03.rentravel.user.service.InsuranceService;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {
	
	private final InsuranceMapper insuranceMapper;
	private final InsuranceService insuranceService;
	
	public InsuranceController(InsuranceMapper insuranceMapper, InsuranceService insuranceService) {
		this.insuranceMapper = insuranceMapper;
		this.insuranceService = insuranceService;
	}
	
	@GetMapping("/insuranceMain")
	public String insuranceMain(Model model) {		
		model.addAttribute("title", "보험메인화면");
		
		return "user/insurance/insuranceMain";
	}
	
	@GetMapping("/insuranceList")
	public String getInsuranceList(HttpServletResponse response, Model model, HttpSession session) throws IOException {
		
		if(session.getAttribute("S_USER_INFO") != null) {
			LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");  // 세션에서 값을 가져오는 방법
			String loginId =  loginInfo.getLoginId();
			
			List<Insurance> insuranceList = insuranceMapper.getInsuranceInfoById(loginId);
			
			model.addAttribute("title", "보험가입정보");
			model.addAttribute("insuranceList", insuranceList);
			
			return "user/insurance/insuranceList"; //html경로를 찾아감
			
		} else {
			
			CommonController.alertPlzLogin(response);
			
			return "user/user/login";
		}
		
	}
	
	@GetMapping("/insuranceBillList")
	public String getInsuranceBillList(HttpServletResponse response, Model model, HttpSession session) throws IOException {		
		
		if(session.getAttribute("S_USER_INFO") != null) {
			LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");  // 세션에서 값을 가져오는 방법
			String loginId =  loginInfo.getLoginId();
		
			List<InsuranceBill> insuranceBillList = insuranceMapper.getInsuranceBillInfoById(loginId);
		
			model.addAttribute("title", "보험청구서조회");
			model.addAttribute("insuranceBillList", insuranceBillList);
			
			return "user/insurance/insuranceBillList";
			
		} else {
			
			CommonController.alertPlzLogin(response);
			
			return "user/user/login";
			
		}
	}
	
	@GetMapping("/insuranceBillDetail")
	public String getInsuranceBillDetail(Model model) {
		
		List<InsuranceBillDetail> insuranceBillDetail = insuranceService.getInsuranceBillDetail();
		
		model.addAttribute("title", "보상금청구서상세화면");
		model.addAttribute("insuranceBillDetail", insuranceBillDetail);
		
		
		return "user/insurance/insuranceBillDetail";
	}
	
	@GetMapping("/insuranceAddBill")
	public String addInsuranceBillDetail(Model model) {
		
		model.addAttribute("title", "보상금청구서등록");
		
		return "user/insurance/insuranceAddBill";
	}
	
	@GetMapping("/insuranceModifyBill")
	public String modifyInsuranceBillDetail(Model model) {		
		model.addAttribute("title", "보상금청구서수정");
		
		return "user/insurance/insuranceModifyBill";
	}
	
	@GetMapping("/insuranceRemoveBill")
	public String removeInsuranceBillDetail(Model model) {
		model.addAttribute("title", "보상금청구서삭제");
		
		return "user/insurance/insuranceRemoveBill";
	}
	
	@GetMapping("/insurancePayoutList")
	public String getInsurancePayoutList(HttpServletResponse response, Model model, HttpSession session) throws IOException {
		
		if(session.getAttribute("S_USER_INFO") != null) {
			LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");  // 세션에서 값을 가져오는 방법
			String loginId =  loginInfo.getLoginId();
		
			List<InsurancePayout> insurancePayoutList = insuranceMapper.getInsurancePayoutInfoById(loginId);
		
			model.addAttribute("title", "보상금지급내역");
			model.addAttribute("insurancePayoutList", insurancePayoutList);
		
			return "user/insurance/insurancePayoutList";
		} else {
			CommonController.alertPlzLogin(response);
			
			return "user/user/login";
			
		}
	}
	
}
