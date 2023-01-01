package ks45team03.rentravel.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks45team03.rentravel.dto.NoticeBoard;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.mapper.NoticeBoardMapper;

@Controller
@RequestMapping("/board")
public class NoticeBoardController {
	
	@Autowired
	private NoticeBoardMapper noticeBoardMapper;
	
	@GetMapping("/noticeBoard")
	public String noticeBoard(Model model
							 ,@RequestParam(defaultValue="1", required=false) int curPage) {
		
		int listCnt = noticeBoardMapper.noticeBoardListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		
		List<NoticeBoard> noticeBoardList = noticeBoardMapper.noticeBoardList(pagination.getStartIndex(), pagination.getPageSize());
		
		model.addAttribute("title", "공지사항");
		model.addAttribute("noticeBoardList", noticeBoardList);
		model.addAttribute("pagination", pagination);
		
		return "user/board/noticeBoardList";
	}
	
	@GetMapping("/detailNoticeBoard")
	public String detailNoticeBoard(Model model
								   ,@RequestParam(value = "noticeBoardCode") String noticeBoardCode) {
		
		NoticeBoard detailNoticeBoard = noticeBoardMapper.detailNoticeBoard(noticeBoardCode);
		
		model.addAttribute("title", "공지사항");
		model.addAttribute("detailNoticeBoard", detailNoticeBoard);
		
		return "user/board/detailNoticeBoard";
	}
}
