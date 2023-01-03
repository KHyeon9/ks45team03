package ks45team03.rentravel.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.CommisionRate;
import ks45team03.rentravel.mapper.AdminBlockMapper;

@Service
@Transactional
public class AdminBlockService {
	
	private final AdminBlockMapper adminBlockMapper;
	
	public AdminBlockService(AdminBlockMapper adminBlockMapper) {
		
		this.adminBlockMapper = adminBlockMapper;
	}


	
	
	
	/* 회원 차단 목록 조회 */
	public Map<String, Object> adminGetUserBlockList (int currentPage, String searchKey, String searchValue){
		
		// 보여질 행의 개수
		int rowPerPage = 10;
		
		// 보여질 행의 시작점
		int startRowNum = (currentPage - 1)*rowPerPage;
		
		// 마지막페이지 
		// 테이블의 전체 행의 갯수
		double rowCnt = adminBlockMapper.getBlockListCnt();
		// 마지막페이지
		int lastPage = (int) Math.ceil(rowCnt/rowPerPage);
		
		// 보여질 페이지 번호 구현
		// 보여질 페이지 번호 초기화
		int endPageNum = (int) Math.ceil(currentPage * 0.1) * 10;
		int startPageNum =  Math.max(endPageNum - 10 + 1, 1);
		
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
		
		// 주문 목록 조회 시 Limit 인수 파라미터 셋팅
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRowNum", startRowNum);
		paramMap.put("rowPerPage", rowPerPage);
		
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
		
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
	
		
		List<Block> adminGetUserBlockList = adminBlockMapper.adminGetUserBlockList(paramMap);
		
		paramMap.clear();
		paramMap.put("adminGetUserBlockList", adminGetUserBlockList);
		paramMap.put("lastPage", lastPage);
		paramMap.put("startPageNum", startPageNum);
		paramMap.put("endPageNum", endPageNum);
		paramMap.put("nextPage", nextPage);
		paramMap.put("prevPage", prevPage);
		return paramMap;

		
	}
}
