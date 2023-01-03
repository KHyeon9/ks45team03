package ks45team03.rentravel.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.admin.service.AdminBlockService;
import ks45team03.rentravel.dto.Block;

@Controller
@RequestMapping("/admin/block")
public class AdminBlockController {
	
	private final AdminBlockService adminBlockService;
	
	public AdminBlockController (AdminBlockService adminBlockService) {
		this.adminBlockService = adminBlockService;
	}

	@GetMapping("/adminBlockList")
	public String adminGetUserBlockList(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage
										,@RequestParam(value="searchKey", required = false) String searchKey
										,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue
										,Model model) {
		
		Map<String, Object> paramMap = adminBlockService.adminGetUserBlockList(currentPage, searchKey, searchValue);
		
		List<Block> adminGetUserBlockList = (List<Block>) paramMap.get("adminGetUserBlockList");
		
		System.out.println("adminGetUserBlockList");
		
		
		int lastPage = (int) paramMap.get("lastPage");
		int startPageNum = (int) paramMap.get("startPageNum");
		int endPageNum = (int) paramMap.get("endPageNum");
		int nextPage = (int) paramMap.get("nextPage");
		int prevPage = (int) paramMap.get("prevPage");
		
		model.addAttribute("title","관리자 회원 아이디 차단 목록");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("adminGetUserBlockList", adminGetUserBlockList);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("prevPage", prevPage);
		
		
		
		return "admin/block/adminBlockList";
	}
}
