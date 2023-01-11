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
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.mapper.AdminBlockMapper;

@Controller
@RequestMapping("/admin/block")
public class AdminBlockController {
	
	private final AdminBlockService adminBlockService;
	private final AdminBlockMapper adminBlockMapper;
	
	public AdminBlockController (AdminBlockService adminBlockService, AdminBlockMapper adminBlockMapper) {
		this.adminBlockService = adminBlockService;
		this.adminBlockMapper = adminBlockMapper;
	}

	@GetMapping("/adminBlockList")
	public String adminGetUserBlockList(@RequestParam(defaultValue="1", required=false) int curPage
										,@RequestParam(value="searchKey", required = false) String searchKey
										,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue
										,Model model) {
		
		
		int listCnt = adminBlockMapper.getBlockListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		
		List<Block> adminGetUserBlockList = adminBlockService.adminGetUserBlockList(pagination.getStartIndex(), pagination.getPageSize(), searchKey, searchValue);
				
		
		model.addAttribute("title","관리자 회원 아이디 차단 목록");
		model.addAttribute("pagination",pagination);
		model.addAttribute("adminGetUserBlockList", adminGetUserBlockList);
	
		
		
		
		return "admin/block/adminBlockList";
	}
}
