package ks45team03.rentravel.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.LoginInfo;
import ks45team03.rentravel.dto.Pagination;
import ks45team03.rentravel.dto.RegionSgg;
import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.dto.SleeperAccount;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.dto.UserEvaluation;
import ks45team03.rentravel.mapper.UserMapper;
import ks45team03.rentravel.user.service.GoodsService;
import ks45team03.rentravel.user.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class UserController {

	private final UserService userService;
	private final UserMapper userMapper;
	private final GoodsService goodsService;

	// 닉네임 중복 체크 컨트롤러
	@GetMapping("/addUser/nickNameCheck")
	@ResponseBody
	public boolean nickNameCheck(@RequestParam(value = "userNickName") String userNickName) {

		boolean nickNameCheck = false;

		nickNameCheck = userMapper.checkUserNickName(userNickName);

		return nickNameCheck;
	}

	// id 중복 체크 컨트롤러
	@GetMapping("/addUser/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam(value = "userId") String userId) {

		boolean idCheck = false;

		idCheck = userMapper.checkUserId(userId);

		return idCheck;
	}

	@RequestMapping(value = "/addUser/ajaxProject", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<RegionSgg>> ajaxProject(@RequestParam(value = "project") String project)
			throws Exception {

		ResponseEntity<List<RegionSgg>> entity = null;

		try {

			List<RegionSgg> list = userService.selectRegionSgg(project);
			entity = new ResponseEntity<List<RegionSgg>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			entity = new ResponseEntity<List<RegionSgg>>(HttpStatus.BAD_REQUEST);

			return entity;
		}
		return entity;
	}

	@PostMapping("/addUser")
	public String addUsser(User user) {

		userService.addUser(user);

		return "redirect:/";
	}

	@GetMapping("/addUser")
	public String addUser(Model model) {

		List<RegionSido> getRegionSido = userService.getRegionSido();

		model.addAttribute("title", "회원가입");
		model.addAttribute("getRegionSido", getRegionSido);

		return "user/user/addUser";
	}

	@PostMapping("/disableSleeperAccount")
	public String disableSleeperAccount(@RequestParam(value = "userId") String userId, HttpSession session) {

		Map<String, Object> checkResult = userService.userInfo(userId);

		User user = (User) checkResult.get("userInfo");

		LoginInfo loginInfo = new LoginInfo(userId, user.getUserNickName(), user.getUserLevelName());

		session.setAttribute("S_USER_INFO", loginInfo);

		LoginInfo userInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
		userMapper.loginHistory(userInfo.getLoginId());

		return "redirect:/";
	}

	@GetMapping("/disableSleeperAccount")
	public String disableSleeperAccount(Model model, @RequestParam(value = "userId") String userId) {

		SleeperAccount getSleeperAccount = userMapper.getSleeperAccount(userId);

		model.addAttribute("title", "휴면계정해제");
		model.addAttribute("getSleeperAccount", getSleeperAccount);

		return "user/user/disableSleeperAccount";
	}

	// 로그인 처리
	@PostMapping("/login")
	public String login(@RequestParam(value = "userId") String userId, @RequestParam(value = "userPw") String userPw,
			RedirectAttributes reAttr, HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Map<String, Object> checkResult = userService.checkPwByUserId(userId, userPw);

		boolean isChecked = (boolean) checkResult.get("result");
		String redirectURI;

		redirectURI = "redirect:" + session.getAttribute("referer");
		// 비밀번호 미일치시
		if (!isChecked) {
			redirectURI = "redirect:/login";
			reAttr.addAttribute("msg", "아이디(ID)와 비밀번호를 확인하고 다시 로그인해주세요.");
		} else {
			int checkRemoveId = userMapper.checkRemoveId(userId);
			int checkSleeperId = userMapper.checkSleeperId(userId);

			if (checkRemoveId == 1) {

				CommonController.alertRemoveAccount(response);

				return "user/user/login";
			} else if (checkSleeperId == 1) {
				session.setAttribute("userId", userId);
				redirectURI = "redirect:/disableSleeperAccount?userId=" + userId;

			} else {
				// 비밀번호 일치
				User user = (User) checkResult.get("userInfo");

				LoginInfo loginInfo = new LoginInfo(userId, user.getUserNickName(), user.getUserLevelName());

				session.setAttribute("S_USER_INFO", loginInfo);

				LoginInfo userInfo = (LoginInfo) session.getAttribute("S_USER_INFO");
				userMapper.loginHistory(userInfo.getLoginId());
			}
		}

		return redirectURI;

	}

	// 로그인 화면
	@GetMapping("/login")
	public String login(Model model, @RequestParam(value = "msg", required = false) String msg,
			HttpServletRequest request, HttpSession session) {

		String referer = request.getHeader("Referer");

		if (!referer.contains("/login")) {
			session.setAttribute("referer", referer);
		}

		model.addAttribute("title", "login");
		if (msg != null)
			model.addAttribute("msg", msg);

		return "user/user/login";
	}

	// 로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/";
	}

	@ResponseBody
	@PostMapping("/findId")
	public int findId(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "userEmail") String userEmail,
			@RequestParam(value = "userPhoneNumber") String userPhoneNumber) {

		int findIdCheck = userService.findIdCheck(userName, userEmail, userPhoneNumber);

		return findIdCheck;
	}

	// 아이디 찾기
	@GetMapping("/findId")
	public String findId(Model model) {

		model.addAttribute("title", "아이디 찾기");

		return "user/user/findId";
	}

	@GetMapping("/showFindId")
	public String showFindId(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "userEmail") String userEmail,
			@RequestParam(value = "userPhoneNumber") String userPhoneNumber, Model model) {

		List<User> showFindId = userMapper.showFindId(userName, userEmail, userPhoneNumber);

		model.addAttribute("title", "아이디 찾기");
		model.addAttribute("showFindId", showFindId);

		return "user/user/showFindId";
	}

	// 비밀번호 찾기
	@GetMapping("/findPw")
	public String findPw(Model model) {

		model.addAttribute("title", "비밀번호 찾기");

		return "user/user/findPw";
	}

	@GetMapping("/userMyPage")
	public String myGoodsList(Model model 
							 ,HttpSession session
							 ,@RequestParam(value="userNickName") String userNickName
							 ,@RequestParam(defaultValue = "1", required = false) int curPage) {

		LoginInfo loginUser = (LoginInfo) session.getAttribute("S_USER_INFO");
		String returnURI;
		
		if (loginUser == null) {
			returnURI = "redirect:/login";
		} else {
			int myGoodsListCount2 = goodsService.getMyGoodsListCount2(userNickName);

			Pagination pagination = new Pagination(myGoodsListCount2, curPage);

			int startIndex = pagination.getStartIndex();
			int pageSize = pagination.getPageSize();

			List<Goods> myGoodsList2 = goodsService.getMyGoodsList2(userNickName, startIndex, pageSize);
			int getDuplicateEvaluation = userMapper.getDuplicateEvaluation(userNickName, loginUser.getLoginId());

			model.addAttribute("myGoodsList2", myGoodsList2);
			model.addAttribute("pagination", pagination);
			model.addAttribute("title", "마이페이지 화면");
			model.addAttribute("getDuplicateEvaluation", getDuplicateEvaluation);
			model.addAttribute("userNickName", userNickName);

			returnURI = "user/user/myPage";

		}
		return returnURI;
	}
	
	
	@GetMapping("/userMyEvaluation")
	public String userEvaluation(Model model
								,HttpSession session
								,@RequestParam(value="userNickName") String userNickName) {
		
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("S_USER_INFO");

		
		List<UserEvaluation> userEvaluation2 = userService.userEvaluation2(userNickName);
		
		model.addAttribute("title","내 평가");
		model.addAttribute("userEvaluation2", userEvaluation2);
		model.addAttribute("userNickName", userNickName);
		
		return "user/user/userEvaluation";
	}

}
