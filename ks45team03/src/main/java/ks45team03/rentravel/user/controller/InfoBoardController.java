package ks45team03.rentravel.user.controller;

import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.InfoBoardComment;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.UserMapper;
import ks45team03.rentravel.user.service.InfoBoardService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/infoboard")
@AllArgsConstructor
@Slf4j
public class InfoBoardController {

	private final InfoBoardService infoBoardService;
	private final CommonNewCode commonNewCode;
	private final UserMapper userMapper;

	/*
	 * public InfoBoardController(InfoBoardService infoBoardService) {
	 * this.infoBoardService = infoBoardService; }
	 * List<Map<String, Object>> paramMaps
	 */
	
	 @ResponseBody
	 @PostMapping("/infoBoardDetail/modifyComment") 
	 public void modifyComment(@RequestBody InfoBoardComment comment) {
		 infoBoardService.modifyInfoBoardComment(comment);
	}
	
	 @ResponseBody
	 @PostMapping("/infoBoardDetail/removeComment") 
	 public void removeComment(@RequestBody String infoBoardCommentCode) {
		 
		 infoBoardService.removeInfoBoardComment(infoBoardCommentCode);
	}

	 @ResponseBody
	 @PostMapping("/infoBoardDetail/addComment") 
	 public void addComment(@RequestBody InfoBoardComment comment) {
		 String infoBoardCommentCode = commonNewCode.getCommonNewCode("tb_info_board_comment", "info_board_comment_code");
		 comment.setInfoBoardCommentCode(infoBoardCommentCode);
		 infoBoardService.addInfoBoardComment(comment);
	}	

	@GetMapping("/removeInfoBoard")
	public String removeInfoBoard(Model model) {
		return "redirect:/";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/infoBoardList")
	public String infoBoardList(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, Model model) {
		Map<String, Object> paramMap = infoBoardService.getInfoBoardList(currentPage);

		List<InfoBoard> infoBoardList = (List<InfoBoard>) paramMap.get("infoBoardList");
		int lastPage = (int) paramMap.get("lastPage");
		int startPageNum = (int) paramMap.get("startPageNum");
		int endPageNum = (int) paramMap.get("endPageNum");
		int nextPage = (int) paramMap.get("nextPage");
		int prevPage = (int) paramMap.get("prevPage");

		model.addAttribute("title", "정보게시판리스트");

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("infoBoardList", infoBoardList);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("prevPage", prevPage);

		return "user/board/infoBoardList";
	}

	@GetMapping("/infoBoardDetail")
	public String infoBoardDetail(@RequestParam(value = "infoBoardCode", required = false) String infoBoardCode,
			HttpSession session, Model model) {

		InfoBoard infoBoardDetail = infoBoardService.getInfoBoardDetail(infoBoardCode);
		List<InfoBoardComment> commentList = infoBoardService.getInfoBoardComment(infoBoardCode);
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		int commentCnt = infoBoardService.getCommnetCnt(infoBoardCode);
		if (loginInfo != null) {
			User userCheck = userMapper.checkPwByUserId(loginInfo.getLoginId());
			model.addAttribute("nickName", userCheck.getUserNickName());
		}
		model.addAttribute("title", "정보게시판상세");
		model.addAttribute("infoBoardDetail", infoBoardDetail);
		model.addAttribute("commentList", commentList);
		model.addAttribute("commentCnt", commentCnt);
		model.addAttribute("loginInfo", loginInfo);

		return "user/board/infoBoardDetail";
	}

	@PostMapping("/modifyInfoBoard")
	public String modifyInfoBoard(InfoBoard infoBoard) {
		infoBoardService.modifyInfoBoard(infoBoard);
		
		return "redirect:/infoboard/infoBoardDetail?infoBoardCode=" + infoBoard.getInfoBoardCode();
	}
	
	@GetMapping("/modifyInfoBoard")
	public String modifyInfoBoard(@RequestParam(value = "infoBoardCode") String infoBoardCode,
								  Model model) {
		InfoBoard infoBoardDetail = infoBoardService.getInfoBoardDetail(infoBoardCode);
		
		model.addAttribute("title", "정보게시판수정");
		model.addAttribute("infoBoardDetail", infoBoardDetail);
		
		return "user/board/modifyInfoBoard";
	}

	@PostMapping("/addInfoBoard")
	public String addInfoBoard(InfoBoard infoBoard) {
		String infoBoardCode = commonNewCode.getCommonNewCode("tb_info_board", "info_board_code");
		infoBoard.setInfoBoardCode(infoBoardCode);

		infoBoardService.addInfoBoard(infoBoard);

		return "redirect:/infoboard/infoBoardList";
	}

	@GetMapping("/addInfoBoard")
	public String addInfoBoard(HttpSession session, Model model) {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");

		if (loginInfo == null) {
			System.out.println("로그인 부탁합니다.");
			return "redirect:/infoboard/infoBoardList";
		}

		model.addAttribute("title", "정보게시판등록");
		model.addAttribute("loginId", loginInfo.getLoginId());

		return "user/board/addInfoBoard";
	}
}
