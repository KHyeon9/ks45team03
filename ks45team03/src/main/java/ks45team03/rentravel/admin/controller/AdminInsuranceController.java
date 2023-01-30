package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import ks45team03.rentravel.admin.service.AdminInsuranceService;
import ks45team03.rentravel.dto.Insurance;
import ks45team03.rentravel.dto.InsuranceBill;
import ks45team03.rentravel.dto.InsuranceBillDetail;
import ks45team03.rentravel.dto.InsuranceBillState;
import ks45team03.rentravel.dto.InsurancePayout;
import ks45team03.rentravel.mapper.AdminInsuranceMapper;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.user.controller.CommonController;


@Controller
@RequestMapping("/admin/insurance")
public class AdminInsuranceController {
	
	private final AdminInsuranceMapper adminInsuranceMapper;
	private final AdminInsuranceService adminInsuranceService;
	
	@Autowired
	private final CommonNewCode commonNewCode;
	
	public AdminInsuranceController(AdminInsuranceMapper adminInsuranceMapper, AdminInsuranceService adminInsuranceService, CommonNewCode commonNewCode) {
		this.adminInsuranceMapper = adminInsuranceMapper;
		this.adminInsuranceService = adminInsuranceService;
		this.commonNewCode = commonNewCode;
	}

	@GetMapping("/adminInsuranceList")
	public String adminGetInsuranceList(Model model) {
		
		List<Insurance> adminInsuranceList = adminInsuranceMapper.adminGetInsuranceList();
		
		model.addAttribute("title", "보험가입정보");
		model.addAttribute("adminInsuranceList", adminInsuranceList);
		
		
		return "admin/insurance/adminInsuranceList"; //html경로를 찾아감
	}
	
	@GetMapping("/adminInsuranceBillList")
	public String adminGetInsuranceBillList(Model model) {
		
		List<InsuranceBill> adminInsuranceBillList = adminInsuranceMapper.adminGetInsuranceBillList();
		
		model.addAttribute("title", "보험청구서");
		model.addAttribute("adminInsuranceBillList", adminInsuranceBillList);
		
		return "admin/insurance/adminInsuranceBillList";
	}
	
	@GetMapping("/adminInsuranceBillDetail")
	public String adminGetInsuranceBillDetail(Model model) {
		
		List<InsuranceBillDetail> adminInsuranceBillDetail = adminInsuranceMapper.adminGetInsuranceBillDetail();
		
		model.addAttribute("title", "보상금청구서상세화면");
		model.addAttribute("adminInsuranceBillDetail", adminInsuranceBillDetail);
		
		return "admin/insurance/adminInsuranceBillDetail";
	}

	
	@GetMapping("/adminInsuranceBillState")
	@ResponseBody
	public List<InsuranceBillState> adminGetInsuranceBillStateList(HttpServletResponse response, Model model) {
		
		List<InsuranceBillState> adminInsuranceBillStateList = adminInsuranceMapper.adminGetInsuranceBillStateList();
		model.addAttribute("adminInsuranceBillStateList", adminInsuranceBillStateList);
		
		return adminInsuranceBillStateList;
	}
	
	
	@RequestMapping(value = "/adminModifyInsuranceBillState", method = { RequestMethod.POST })
	public String adminModifyInsuranceBillState(@RequestParam(value = "insuranceBillCode") String insuranceBillCode,
											@RequestParam(value = "insuranceBillStateCode") String insuranceBillStateCode) {
	
		System.out.println("-----------상태업데이트------------");
		adminInsuranceMapper.adminModifyInsuranceBillState(insuranceBillCode, insuranceBillStateCode);
		
		String redirectURI = "redirect:/admin/insurance/adminInsuranceBillList";
		
		return redirectURI;
	}
	
	
	@GetMapping("/adminInsurancePayoutList")
	public String adminGetInsurancePayoutList(Model model) {
		
		List<InsurancePayout> adminInsurancePayoutList = adminInsuranceMapper.adminGetInsurancePayoutList();
		
		model.addAttribute("title", "보상금지급내역");
		model.addAttribute("adminInsurancePayoutList", adminInsurancePayoutList);
		
		return "admin/insurance/adminInsurancePayoutList";
	}
	
	@ResponseBody
	@GetMapping("/adminInsurancePayoutCode")
	public List<InsurancePayout> adminGetInsurancePayoutCode(Model model) {
		
		List<InsurancePayout> adminInsurancePayoutCode = adminInsuranceMapper.adminGetInsurancePayoutList();
		
		model.addAttribute("adminInsurancePayoutCode", adminInsurancePayoutCode);
		
		return adminInsurancePayoutCode;
	}
	
	@GetMapping("/adminAddInsurancePayout/{insuranceBillCode}")
	public String adminAddInsurancePayoutList(@PathVariable(value="insuranceBillCode") String insuranceBillCode, Model model) {
		model.addAttribute("title", "보상금지급내역등록");
		
		List<InsuranceBill> adminInsuranceBillList = adminInsuranceMapper.adminGetInsuranceBillInfoByCode(insuranceBillCode);
		System.out.println(adminInsuranceBillList);
		
		String newInsurancePayoutCode = commonNewCode.getCommonNewCode("tb_insurance_payout", "insurance_payout_code");
		
		model.addAttribute("newInsurancePayoutCode", newInsurancePayoutCode);
		System.out.println(newInsurancePayoutCode + "<-newInsurancePayoutCode");
		model.addAttribute("adminInsuranceBillList", adminInsuranceBillList);
		
		return "admin/insurance/adminAddInsurancePayout";
	}
	
	@PostMapping("/adminAddInsurancePayout")
	public String adminAddInsurancePayoutList(InsurancePayout insurancePayout, Model model) {
		System.out.println("보상금지급내역등록");
		model.addAttribute("title", "보상금지급내역등록");
		
		System.out.println(insurancePayout);

		adminInsuranceMapper.adminAddInsurancePayout(insurancePayout);
		
		String redirectURI = "redirect:/admin/insurance/adminInsurancePayoutList";
		
		return redirectURI;
	}
	
	@GetMapping("/adminModifyInsurancePayout")
	public String adminModifyInsurancePayout(@RequestParam(value="insurancePayoutCode") String insurancePayoutCode, Model model) {
		
		model.addAttribute("title", "보상금지급내역수정");
		
		List<InsurancePayout> adminInsurancePayoutList = adminInsuranceMapper.adminGetInsurancePayoutInfoByCode(insurancePayoutCode);
		
		model.addAttribute("adminInsurancePayoutList", adminInsurancePayoutList);
		
		return "admin/insurance/adminModifyInsurancePayout";
	}
	
	@PostMapping("/adminModifyInsurancePayout")
	public String adminModifyInsurancePayout(InsurancePayout insurancePayout, Model model) {
		System.out.println("----------보상금지급내역수정-----------");
		model.addAttribute("title", "보상금지급내역수정");
		
		System.out.println(insurancePayout);

		adminInsuranceMapper.adminModifyInsurancePayout(insurancePayout);
		
		String redirectURI = "redirect:/admin/insurance/adminInsurancePayoutList";
		
		return redirectURI;
	}
		
	@PostMapping("/adminRemoveInsurancePayout")
	public String adminRemoveInsurancePayout(String insurancePayoutCode) {
		System.out.println("----------보상금지급내역삭제-----------");
		
		System.out.println(insurancePayoutCode);
		
		adminInsuranceMapper.adminRemoveInsurancePayout(insurancePayoutCode);
		
		String redirectURI = "redirect:/admin/insurance/adminInsurancePayoutList";
		
		return redirectURI;
		
	}
	
}
