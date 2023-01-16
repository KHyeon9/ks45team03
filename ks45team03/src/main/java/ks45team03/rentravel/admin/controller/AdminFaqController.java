package ks45team03.rentravel.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.admin.service.AdminFAQService;
import ks45team03.rentravel.dto.FAQ;
import ks45team03.rentravel.dto.FAQCategory;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.Search;
import ks45team03.rentravel.mapper.AdminFAQMapper;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/board")
public class AdminFaqController {
	
	private final AdminFAQService adminFAQService;
	private final AdminFAQMapper adminFAQMapper;
	
	@GetMapping("/adminFAQ")
	public String adminFAQ(@RequestParam(defaultValue="1", required=false) int curPage
						  ,@RequestParam(value="searchKey", required = false, defaultValue = "") String searchKey
						  ,@RequestParam(value="searchValue", required = false, defaultValue = "") String searchValue
						  ,Model model) {
		
		
		int listCnt = adminFAQMapper.faqListCnt(searchKey, searchValue);
		Pagination pagination = new Pagination(listCnt, curPage);
		Search search = new Search(searchKey, searchValue);
		
		List<FAQ> adminFAQList = adminFAQService.adminFAQList(pagination.getStartIndex(), pagination.getPageSize(), searchKey, searchValue);

		model.addAttribute("title", "FAQ");
		model.addAttribute("adminFAQList", adminFAQList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("search", search);
		
		return "admin/board/adminFAQList";
	}
	
	@PostMapping("/adminAddFAQ") 
	public String adminAddFAQ(FAQ faq) {
	
		adminFAQMapper.adminAddFAQ(faq);
		
		return "redirect:/admin/board/adminFAQ"; 
	}
	 
	
	 @GetMapping("/adminAddFAQ") 
	 public String adminAddFAQ(Model model, HttpSession session) {
	 
		 LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		 String loginId = loginUser.getLoginId();
		 
		 List<FAQCategory> FAQCategoryList = adminFAQMapper.FAQCategoryList();
		 
		 model.addAttribute("title", "FAQ 등록"); 
		 model.addAttribute("loginId", loginId);
		 model.addAttribute("FAQCategoryList", FAQCategoryList);
		 
		 return "admin/board/adminAddFAQ"; 
	 }
	  
	 @GetMapping("/adminDetailFAQ") 
	 public String adminDetailFAQ(Model model
			 						,@RequestParam(value="faqBoardCode") String faqBoardCode) {
		 
		 FAQ adminDetailFAQ = adminFAQService.adminDetailFAQ(faqBoardCode);
		 
		 model.addAttribute("title", "FAQ"); 
		 model.addAttribute("adminDetailFAQ",adminDetailFAQ);
		  
		 return "admin/board/adminDetailFAQ"; 
	 }
	  
	 @GetMapping("/adminRemoveFAQ") 
	 public String adminRemoveFAQ(@RequestParam(value="faqBoardCode") String faqBoardCode) {
	 
		 adminFAQService.adminRemoveFAQ(faqBoardCode);
		 
		 return "redirect:/admin/board/adminFAQ"; 
	 }
		 
		
	 @PostMapping("/adminModifyFAQ") 
	 public String adminModifyFAQ(FAQ faq) {
		
		 adminFAQMapper.adminModifyFAQ(faq);
		  
		 return "redirect:/admin/board/adminFAQ"; 
	}
		 

	 @GetMapping("/adminModifyFAQ")
	 public String adminModifyFAQ(Model model
			 						,@RequestParam(value="faqBoardCode") String faqBoardCode) {
	 
		 FAQ modifyFAQ = adminFAQMapper.modifyFAQ(faqBoardCode);
		 List<FAQCategory> FAQCategoryList = adminFAQMapper.FAQCategoryList();
		 
		 model.addAttribute("title", "FAQ 수정");
		 model.addAttribute("modifyFAQ", modifyFAQ);
		 model.addAttribute("FAQCategoryList", FAQCategoryList);
		 
		 return "admin/board/adminModifyFAQ";
		 
		 }
	 
}
