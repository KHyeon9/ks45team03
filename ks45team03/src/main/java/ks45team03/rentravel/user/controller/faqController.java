package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.dto.FAQ;
import ks45team03.rentravel.mapper.FAQMapper;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class faqController {
	
	private final FAQMapper faqMapper;
	
	@GetMapping("/FAQList")
	public String FAQList(Model model) {
		
		List<FAQ> FAQList = faqMapper.FAQList();
		
		model.addAttribute("title", "FAQ");
		model.addAttribute("FAQList", FAQList);
		
		return "user/board/FAQ";
	}
	
	@GetMapping("/FAQDetail")
	public String FAQDetail(Model model
						   ,@RequestParam(value="faqBoardCode") String faqBoardCode) {
		
		FAQ FAQDetail = faqMapper.FAQDetail(faqBoardCode);
		
		model.addAttribute("FAQDetail", FAQDetail);
		
		return "user/board/FAQDetail";
	}

}
