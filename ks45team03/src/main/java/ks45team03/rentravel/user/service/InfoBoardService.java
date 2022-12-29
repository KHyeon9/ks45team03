package ks45team03.rentravel.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.mapper.InfoBoardMapper;

@Service
@Transactional
public class InfoBoardService {
	
	private final InfoBoardMapper infoBoardMapper;
	
	public InfoBoardService(InfoBoardMapper infoBoardMapper) {
		this.infoBoardMapper = infoBoardMapper;
	}
	
	public Map<String, Object> getInfoBoardList(int currentPage) {
		// 테이블의 전체 행의 갯수
		double rowCnt = infoBoardMapper.getInfoBoardListCnt();
		
		// 보여질 행의 갯수
		int rowPerPage = 10;
		
		// 보여질 행의 시작점
		int startRowNum = (currentPage - 1) * rowPerPage;
		
		// 마지막페이지
		int lastPage = (int) Math.ceil(rowCnt/rowPerPage);
		
		// 보여질 페이지 번호 구현
		// 보여질 페이지 번호 초기화
		int endPageNum = (int) Math.ceil(currentPage * 0.1) * 10;
		int startPageNum = endPageNum - 10 + 1;
		
		int prevPage = (int) Math.floor(currentPage * 0.1) * 10;
		if(currentPage % 10 == 0) {
			prevPage = (int) Math.floor(currentPage * 0.1) * 10 - 10;
		}
		int nextPage = (int) Math.ceil(currentPage * 0.1) * 10 + 1;
		
		if(endPageNum > lastPage) {
			endPageNum = lastPage;
		}
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRowNum", startRowNum);
		paramMap.put("rowPerPage", rowPerPage);
		
		// 정보 게시판 목록 data
		List<InfoBoard> infoBoardList = infoBoardMapper.getInfoBoardList(paramMap);
		
		// controller에 전달하기 위한 파라미터 셋팅
		paramMap.clear();
		paramMap.put("infoBoardList", infoBoardList);
		paramMap.put("lastPage", lastPage);
		paramMap.put("startPageNum", startPageNum);
		paramMap.put("endPageNum", endPageNum);
		paramMap.put("nextPage", nextPage);
		paramMap.put("prevPage", prevPage);
		
		return paramMap;
		
	}
}
