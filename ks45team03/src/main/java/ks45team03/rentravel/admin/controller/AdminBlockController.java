package ks45team03.rentravel.admin.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.Search;
import ks45team03.rentravel.mapper.AdminBlockMapper;

@Controller
@RequestMapping("/admin/block")
public class AdminBlockController {
	
	private final AdminBlockMapper adminBlockMapper;
	
	public AdminBlockController (AdminBlockMapper adminBlockMapper) {
		this.adminBlockMapper = adminBlockMapper;
	}

	@GetMapping("/adminBlockList")
	public String adminGetUserBlockList(@RequestParam(defaultValue="1", required=false) int curPage
										,@RequestParam(value="searchKey", required = false) String searchKey
										,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue
										,Model model) {		
		if(searchKey != null) {
			switch (searchKey) {
			case "blockCode":
				searchKey = "block_code";
				break;
			case "blockingUserId":
				searchKey = "blocking_user_id";
				break;	
			case "blockedUserId":
				searchKey = "blocked_user_id";
				break;	
			case "blockDate":
				searchKey = "block_date";
				break;	
			}
		}
		
		int listCnt = adminBlockMapper.getBlockListCnt(searchKey,searchValue);
		Pagination pagination = new Pagination(listCnt, curPage);
		Search search = new Search(searchKey, searchValue);
		
		List<Block> adminGetUserBlockList = adminBlockMapper.adminGetUserBlockList(pagination.getStartIndex(), pagination.getPageSize(), searchKey, searchValue);
				
		
		model.addAttribute("title","관리자 회원 아이디 차단 목록");
		model.addAttribute("pagination",pagination);
		model.addAttribute("adminGetUserBlockList", adminGetUserBlockList);
		model.addAttribute("search",search);
	
		
		
		
		return "admin/block/adminBlockList";
	}
}
