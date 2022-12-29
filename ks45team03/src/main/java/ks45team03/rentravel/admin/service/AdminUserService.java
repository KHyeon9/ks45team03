package ks45team03.rentravel.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.mapper.AdminUserMapper;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.dto.UserLevel;

@Service
@Transactional
public class AdminUserService {
	
	// 의준성 주입
	private final AdminUserMapper adminUserMapper;
	
	public AdminUserService(AdminUserMapper adminUserMapper) {
		this.adminUserMapper = adminUserMapper;
	}
	
	// 회원 목록 + 페이징
	public Map<String, Object> userList(int currentPage, String searchKey, String searchValue){
		
		// 검색 
		if(searchKey != null) {
			switch (searchKey) {
			case "userId":
				searchKey = "u.user_id";
				break;
			case "userLevelName":
				searchKey = "ul.user_level_name";
				break;
			case "userName":
				searchKey = "u.user_name";
				break;
			case "userNickName":
				searchKey = "u.user_nickname";
				break;
			}
		}
		
		// 보여질 행의 갯수
		int rowPerPage = 10;
		
		// 보여질 행의 시작점
		int startRowNum = (currentPage - 1)*rowPerPage;
		
		// 마지막페이지 
		// 테이블의 전체 행의 갯수
		double rowCnt = adminUserMapper.getUserListCnt(searchKey, searchValue);
		// 마지막페이지
		int lastPage = (int) Math.ceil(rowCnt/rowPerPage);
		
		// 보여질 페이지 번호 구현
		// 보여질 페이지 번호 초기화
		int endPageNum = (int) Math.ceil(currentPage * 0.1) * 10;
		int startPageNum = endPageNum - 10 + 1;
		
		// 이전버튼 : [11] ... [20]  -->  [1] ... [10]
		int prevPage = (int) Math.floor(currentPage * 0.1) * 10;
		if(currentPage % 10 == 0) {
			prevPage = (int) Math.floor(currentPage * 0.1) * 10 - 10;
		}
		// 다음버튼 : [1] ... [10]  --> [11] ... [20]
		int nextPage = (int) Math.ceil(currentPage * 0.1) * 10 + 1;
		
		if(endPageNum > lastPage) {
			endPageNum = lastPage;
		}
		
		// 유저목록 조회 시 Limit 인수 파라미터 셋팅
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRowNum", startRowNum);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		// 유저목록 data
		List<User> userList = adminUserMapper.userList(paramMap);
		
		
		// controller에 전달하기 위한 파라미터 셋팅
		paramMap.clear();
		paramMap.put("userList", userList);
		paramMap.put("lastPage", lastPage);
		paramMap.put("startPageNum", startPageNum);
		paramMap.put("endPageNum", endPageNum);
		paramMap.put("nextPage", nextPage);
		paramMap.put("prevPage", prevPage);
		
		return paramMap;
	}
	
	// 수정 처리
	public int modifyUser(User user) {
		
		int result = adminUserMapper.modifyUser(user);
		
		return result;
	}
	
	// 특정 회원 조회(수정)
	public User getUserInfoById(String userId) {
		
		User userInfo = adminUserMapper.getUserInfoById(userId);
		
		return userInfo;
	}
	
	// 회원 등급 조회
	public List<UserLevel> getUserLevelList() {
		List<UserLevel> userLevelList = adminUserMapper.getUserLevelList();
		return userLevelList;
	}
}
