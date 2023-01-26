package ks45team03.rentravel.user.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsurancePayout;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.InsuranceMapper;
import ks45team03.rentravel.user.service.InsuranceService;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {
	
	private final InsuranceMapper insuranceMapper;
	private final InsuranceService insuranceService;
	
	@Autowired
	private final CommonNewCode commonNewCode;
	
	public InsuranceController(InsuranceMapper insuranceMapper, InsuranceService insuranceService, CommonNewCode commonNewCode) {
		this.insuranceMapper = insuranceMapper;
		this.insuranceService = insuranceService;
		this.commonNewCode = commonNewCode;
	}
	@GetMapping("/insuranceMain")
	public String getInsurance(HttpServletResponse response, Model model, HttpSession session) throws IOException {
		
		String URI;
		
		if(session.getAttribute("S_USER_INFO") != null) {
			model.addAttribute("title", "Insurance");
			LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");  // 세션에서 값을 가져오는 방법
			String loginId =  loginInfo.getLoginId();
			
			List<Insurance> insuranceList = insuranceMapper.getInsuranceInfoById(loginId);
			List<InsuranceBill> insuranceBillList = insuranceMapper.getInsuranceBillInfoById(loginId);
			List<InsurancePayout> insurancePayoutList = insuranceMapper.getInsurancePayoutInfoById(loginId);
			
			model.addAttribute("insuranceList", insuranceList);
			model.addAttribute("insuranceBillList", insuranceBillList);
			model.addAttribute("insurancePayoutList", insurancePayoutList);
			 
			URI = "user/insurance/insuranceMain";
			
		} else {
			
			CommonController.alertPlzLogin(response);
			URI = "user/user/login";
			
		}
		return URI;
		
	}
	
	@GetMapping("/insuranceAddBillPersonInfo/{insuranceCode}")
	public String insuranceAddBillPersonInfo(@PathVariable(value="insuranceCode") String insuranceCode, Model model) {
		
		model.addAttribute("title", "Insurance");
		model.addAttribute("insuranceCode", insuranceCode);
		
		return "user/insurance/insuranceAddBillPersonInfo";
			
	}
	
	@PostMapping("/insuranceAddBill")
	public String addInsuranceBillDetail(InsuranceBillDetail insuranceBillDetail, HttpSession session) {
		
		System.out.println("---------보상금청구서 등록------------");
		
		String newInsuranceBillDetailCode = commonNewCode.getCommonNewCode("tb_insurance_bill_detail", "insurance_bill_detail_code");
		
		List<Insurance> insuranceList = insuranceMapper.getInsuranceInfo(insuranceBillDetail.getInsuranceCode());
		
		insuranceBillDetail.setInsuranceBillDetailCode(newInsuranceBillDetailCode);
		System.out.println(insuranceList.toString());
		
		insuranceBillDetail.setUserId(insuranceList.get(0).getUserId());
		insuranceBillDetail.setPaymentCode(insuranceList.get(0).getPaymentCode());
		
		System.out.println(insuranceBillDetail.toString());
		
		insuranceService.addInsuranceBillDetail(insuranceBillDetail);
		
		return "redirect:insuranceBillDetail/" + newInsuranceBillDetailCode;
		
	}
	
	
	@GetMapping("/insuranceAddBill/{insuranceCode}")
	public String addInsuranceBillDetail(@PathVariable(value="insuranceCode") String insuranceCode,
										Model model, HttpSession session) throws IOException {
			model.addAttribute("title", "Insurance");
			model.addAttribute("insuranceCode", insuranceCode);
			
			LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");  // 세션에서 값을 가져오는 방법
			String loginId =  loginInfo.getLoginId();
			
			model.addAttribute("insuranceCode", insuranceCode);
			
			//로그인아이디로 보험리스트조회
			List<Insurance> insuranceList = insuranceMapper.getInsuranceInfoById(loginId);
			model.addAttribute("insuranceList", insuranceList);
			
			//보험코드로 보험리스트 조회
			List<Insurance> insuranceInfo = insuranceMapper.getInsuranceInfo(insuranceCode);
			model.addAttribute("insuranceInfo", insuranceInfo);
			
			//인적사항 조회
			List<Insurance> insuranceUserInfo = insuranceMapper.getInsuranceUser(loginId, insuranceCode);
			model.addAttribute("insuranceUserInfo", insuranceUserInfo);

			return "user/insurance/insuranceAddBill";
		
	}
	
	@ResponseBody
	@GetMapping("/insuranceCode")
	public String justifyInsuranceBillRecipt(@RequestParam(value="insuranceCode", required = false) String insuranceCode, Model model) {
				
		String justifyInsurance = insuranceMapper.justifyInsuranceBillRecipt(insuranceCode);
		
		System.out.println(justifyInsurance);
		
		model.addAttribute("justifyInsurance", justifyInsurance);
		
		return justifyInsurance;
	}
	
	@GetMapping("/insuranceBillRecipt/{insuranceCode}")
	public String getInsuranceBillRecipt(@PathVariable(value="insuranceCode") String insuranceCode, Model model){
		
			model.addAttribute("title", "Insurance");
			model.addAttribute("insuranceCode", insuranceCode);
			
			List<InsuranceBillDetail> insuranceBillDetail = insuranceMapper.getInsuranceBillReciptInfoById(insuranceCode);
			model.addAttribute("insuranceBillDetail", insuranceBillDetail);
			
			return "user/insurance/insuranceBillRecipt";
		
	}
	
	@GetMapping("/insuranceBillDetail/{insuranceBillDetailCode}")
	public String getInsuranceBillDetail(@PathVariable(value="insuranceBillDetailCode") String insuranceBillDetailCode, Model model){
		
			model.addAttribute("title", "Insurance");
			model.addAttribute("insuranceBillDetailCode", insuranceBillDetailCode);
			
			List<InsuranceBillDetail> insuranceBillDetail = insuranceMapper.getInsuranceBillDetailInfoById(insuranceBillDetailCode);
			model.addAttribute("insuranceBillDetail", insuranceBillDetail);
			
			return "user/insurance/insuranceBillDetail";
		
	}

	@PostMapping("/insuranceModifyBill")
	public String modifyInsuranceBillDetail(InsuranceBillDetail insuranceBillDetail) {
		
		System.out.println("보험접수증수정");
		
		System.out.println(insuranceBillDetail.toString());
		
		String insuranceBillDetailCode = insuranceBillDetail.getInsuranceBillDetailCode();
		
		insuranceService.modifyInsuranceBillDetail(insuranceBillDetail);
		
		return "redirect:insuranceBillDetail/" + insuranceBillDetailCode;
	}
	
	
	@GetMapping("/insuranceModifyBill")
	public String modifyInsuranceBillDetail(@RequestParam(value="insuranceBillDetailCode", required = false) String insuranceBillDetailCode, Model model) {
		
		List<InsuranceBillDetail> insuranceBillDetail = insuranceMapper.getInsuranceBillDetailInfoById(insuranceBillDetailCode);
		
		model.addAttribute("title", "Insurance");
		model.addAttribute("insuranceBillDetail", insuranceBillDetail);
		
		return "user/insurance/insuranceModifyBill";
	}
	
	
	
	@PostMapping("/insuranceRemoveBill")
	public String removeInsuranceBillDetail(String insuranceBillDetailCode) {
		
		System.out.println("-------------삭제-------------");
		System.out.println(insuranceBillDetailCode);
			
		insuranceService.removeInsuranceBillDetail(insuranceBillDetailCode);
		
		String redirectURI = "redirect:/insurance/insuranceMain";
		return redirectURI;
	}
	

	
}
