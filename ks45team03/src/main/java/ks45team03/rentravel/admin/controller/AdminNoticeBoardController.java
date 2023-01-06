package ks45team03.rentravel.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.NoticeBoard;
import ks45team03.rentravel.mapper.AdminNoticeBoardMapper;

@Controller
@RequestMapping("/admin/board")
public class AdminNoticeBoardController {
	
	@Autowired
	private AdminNoticeBoardMapper adminNoticeBoardMapper;
	
	@GetMapping("/adminNoticeBoard")
	public String noticeBoard(Model model) {
		
		List<NoticeBoard> adminNoticeBoardList = adminNoticeBoardMapper.adminNoticeBoardList();
		
		model.addAttribute("title", "공지사항");
		model.addAttribute("adminNoticeBoardList", adminNoticeBoardList);
		
		return "admin/board/adminNoticeBoardList";
	}
	
	@PostMapping("/adminAddNoticeBoard")
	public String adminAddNoticeBoard(NoticeBoard noticeBoard) {
		
		adminNoticeBoardMapper.adminAddNoticeBoard(noticeBoard);
		
		return "redirect:/admin/board/adminNoticeBoard";
	}
	
	@GetMapping("/adminAddNoticeBoard")
	public String adminAddNoticeBoard(Model model, HttpSession session) {
		
		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		String loginId = loginUser.getLoginId();
		
		model.addAttribute("title", "공지사항 등록");
		model.addAttribute("loginId", loginId);
		
		
		return "admin/board/adminAddNoticeBoard";
	}
	
	@GetMapping("/adminDetailNoticeBoard")
	public String detailNoticeBoard(Model model
								   ,@RequestParam(value="noticeBoardCode") String noticeBoardCode) {
		
		NoticeBoard detailNoticeBoard = adminNoticeBoardMapper.adminDetailNoticeBoard(noticeBoardCode);
		
		model.addAttribute("title", "공지사항");
		model.addAttribute("detailNoticeBoard", detailNoticeBoard);
		
		return "admin/board/adminDetailNoticeBoard";
	}
	
	@GetMapping("/adminRemoveNoticeBoard")
	public String removeNoticeBoard(@RequestParam(value="noticeBoardCode") String noticeBoardCode) {
		
		adminNoticeBoardMapper.removeNoticeBoard(noticeBoardCode);
		
		return "redirect:/admin/board/adminNoticeBoard";
	}
	
	@PostMapping("/adminModifyNoticeBoard")
	public String modifyNoticeBoard(NoticeBoard noticeBoard) {
		
		adminNoticeBoardMapper.modifyNoticeBoardAction(noticeBoard);
		
		return "redirect:/admin/board/adminNoticeBoard";
	}
	
	@GetMapping("/adminModifyNoticeBoard")
	public String modifyNoticeBoard(Model model
								   ,@RequestParam(value="noticeBoardCode") String noticeBoardCode) {
		
		NoticeBoard modifyNoticeBoard = adminNoticeBoardMapper.modifyNoticeBoard(noticeBoardCode);
		
		model.addAttribute("title", "공지사항 수정");
		model.addAttribute("modifyNoticeBoard", modifyNoticeBoard);
		
		return "admin/board/adminModifyNoticeBoard";
		
	}
}
