package ks45team03.rentravel.user.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.GoodsCategory;
import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.InfoBoardComment;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.InfoBoardMapper;
import ks45team03.rentravel.mapper.UserMapper;
import ks45team03.rentravel.user.service.FileService;
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
	private final InfoBoardMapper infoBoardMapper;
	private final CommonNewCode commonNewCode;
	private final UserMapper userMapper;

	
	// λκΈ μμ 
	 @ResponseBody
	 @PostMapping("/infoBoardDetail/modifyComment") 
	 public void modifyComment(@RequestBody InfoBoardComment comment) {
		 infoBoardService.modifyInfoBoardComment(comment);
	}
	
	 // λκΈ μ­μ 
	 @ResponseBody
	 @PostMapping("/infoBoardDetail/removeComment") 
	 public void removeComment(@RequestBody String infoBoardCommentCode) {
		 
		 infoBoardService.removeInfoBoardComment(infoBoardCommentCode);
	}

	 // λκΈ λ±λ‘
	 @ResponseBody
	 @PostMapping("/infoBoardDetail/addComment") 
	 public void addComment(@RequestBody InfoBoardComment comment) {
		 String infoBoardCommentCode = commonNewCode.getCommonNewCode("tb_info_board_comment", "info_board_comment_code");
		 comment.setInfoBoardCommentCode(infoBoardCommentCode);
		 infoBoardService.addInfoBoardComment(comment);
	}	

	 // κ²μκΈ λͺ©λ‘ μ‘°ν
	@GetMapping("/infoBoardList")
	public String infoBoardList(@RequestParam(value="curPage", defaultValue="1", required=false) int curPage, 
								Model model) {
		int listCnt = infoBoardMapper.getInfoBoardListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		List<InfoBoard> infoBoardList = infoBoardService.getInfoBoardList(pagination.getStartIndex(), pagination.getPageSize());
		List<GoodsCategory> goodsCategoryList = infoBoardMapper.getGoodsCategory();
		
		model.addAttribute("title", "μ λ³΄κ²μνλ¦¬μ€νΈ");
		model.addAttribute("pagination", pagination);
		model.addAttribute("infoBoardList", infoBoardList);
		model.addAttribute("goodsCategoryList", goodsCategoryList);

		return "user/board/infoBoardList";
	}

	// κ²μκΈ μμΈ μ‘°ν
	@GetMapping("/infoBoardDetail")
	public String infoBoardDetail(@RequestParam(value = "infoBoardCode", required = false) String infoBoardCode,
								  @RequestParam(value="curPage", defaultValue="1", required=false) int curPage, 
								  HttpSession session, 
								  Model model) {
		int commentCnt = infoBoardMapper.getCommentCnt(infoBoardCode);
		Pagination pagination = new Pagination(commentCnt, curPage);
		infoBoardService.viewIncrease(infoBoardCode);
		InfoBoard infoBoardDetail = infoBoardService.getInfoBoardDetail(infoBoardCode);
		List<String> infoBoardImgList = infoBoardMapper.getInfoBoardImgPath(infoBoardCode);
		List<InfoBoardComment> commentList = infoBoardMapper.getInfoBoardComment(infoBoardCode, pagination.getStartIndex(), pagination.getPageSize());
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		
		log.info("μ¬μ§ κ²½λ‘ μ λ³΄ : {} ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", infoBoardImgList);
		
		if (loginInfo != null) {
			User userCheck = userMapper.checkPwByUserId(loginInfo.getLoginId());
			model.addAttribute("nickName", userCheck.getUserNickName());
		}
		model.addAttribute("title", "μ λ³΄κ²μνμμΈ");
		model.addAttribute("infoBoardDetail", infoBoardDetail);
		model.addAttribute("commentList", commentList);
		model.addAttribute("commentCnt", commentCnt);
		model.addAttribute("pagination", pagination);
		model.addAttribute("loginInfo", loginInfo);
		model.addAttribute("infoBoardImgList", infoBoardImgList);

		return "user/board/infoBoardDetail";
	}

	// κ²μκΈ μμ  post
	@PostMapping("/modifyInfoBoard")
	public String modifyInfoBoard(InfoBoard infoBoard, MultipartFile[] uploadfile) {
		
		String fileRealPath = "/home/springboot/teamproject/files/";
		
		infoBoard.setInfoBoardContent(infoBoard.getInfoBoardContent().replace("\r\n", "<br>"));
		
		infoBoardService.modifyInfoBoard(infoBoard, uploadfile, fileRealPath);
		
		
		return "redirect:/infoboard/infoBoardDetail?infoBoardCode=" + infoBoard.getInfoBoardCode();
	}
	
	// κ²μκΈ μμ  get
	@GetMapping("/modifyInfoBoard")
	public String modifyInfoBoard(@RequestParam(value = "infoBoardCode") String infoBoardCode,
								  Model model) {
		InfoBoard infoBoardDetail = infoBoardService.getInfoBoardDetail(infoBoardCode);
		
		model.addAttribute("title", "μ λ³΄κ²μνμμ ");
		model.addAttribute("infoBoardDetail", infoBoardDetail);
		
		return "user/board/modifyInfoBoard";
	}
	
	// κ²μκΈ μ­μ 
	@PostMapping("/removeInfoBoard")
	public String removeInfoBoard(String infoboardCode) {
		InfoBoard infoBoard = infoBoardMapper.getInfoBoardDetail(infoboardCode);
		
		infoBoardService.removeInfoBoard(infoBoard);
		
		return "redirect:/infoboard/infoBoardList";
	}
	 
	// κ²μκΈ λ±λ‘ post
	@PostMapping("/addInfoBoard")
	public String addInfoBoard(@RequestPart(value = "uploadfile", required = false) MultipartFile[] uploadfile,
							   HttpServletRequest request,
							   InfoBoard infoBoard) {
		String fileRealPath = "/home/springboot/teamproject/files/";
		String infoBoardCode = commonNewCode.getCommonNewCode("tb_info_board", "info_board_code");
		
		infoBoard.setInfoBoardContent(infoBoard.getInfoBoardContent().replace("\r\n", "<br>"));
		
		infoBoard.setInfoBoardCode(infoBoardCode);

		infoBoardService.addInfoBoard(infoBoard, uploadfile, fileRealPath);

		return "redirect:/infoboard/infoBoardList";
	}

	// κ²μκΈ λ±λ‘ get
	@GetMapping("/addInfoBoard")
	public String addInfoBoard(HttpSession session, HttpServletResponse response, Model model) throws IOException {
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");

		if (loginInfo == null) {
			CommonController.alertPlzLogin(response);
			
			return "user/user/login";
		}
		
		model.addAttribute("title", "μ λ³΄κ²μνλ±λ‘");
		model.addAttribute("loginId", loginInfo.getLoginId());

		return "user/board/addInfoBoard";
	}
}
