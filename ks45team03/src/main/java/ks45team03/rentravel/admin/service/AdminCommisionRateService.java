package ks45team03.rentravel.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.CommisionRate;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.mapper.AdminCommisionRateMapper;

@Service
@Transactional
public class AdminCommisionRateService {

	private final AdminCommisionRateMapper adminCommisionRateMapper;
	
	public AdminCommisionRateService(AdminCommisionRateMapper adminCommisionRateMapper) {
		
		this.adminCommisionRateMapper = adminCommisionRateMapper;
	}
	
		/**
		 * 페이징
		 * @param currentPage
		 * @return
		 */
		public Map<String, Object> paging(int currentPage){
			
			// 보여질 행의 갯수
			int rowPerPage = 10;
			
			// 보여질 행의 시작점
			int startRowNum = (currentPage - 1)*rowPerPage;
			
			// 마지막페이지 
			// 테이블의 전체 행의 갯수
			double rowCnt = adminCommisionRateMapper.adminGetCommisionRateListCnt();
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
			
			// controller에 전달하기 위한 파라미터 셋팅
			paramMap.clear();
			paramMap.put("lastPage", lastPage);
			paramMap.put("startPageNum", startPageNum);
			paramMap.put("endPageNum", endPageNum);
			paramMap.put("nextPage", nextPage);
			paramMap.put("prevPage", prevPage);
			
			return paramMap;
		}
	
	
	
	/**
	 * 플랫폼 수수료율 수정
	 * @param commisionRate
	 * @return
	 */
	public int adminModifyCommisionRate (CommisionRate commisionRate) {
		
		int result = adminCommisionRateMapper.adminModifyCommisionRate(commisionRate);
		
		return result;
	}
	
	
	/**
	 * 특정 플랫폼 수수료율 조회 
	 * @param commisionRateCode
	 * @return
	 */
	public CommisionRate adminGetCommisionRateListByCode (String commisionRateCode) {
		
		CommisionRate commisionRateInfo =  adminCommisionRateMapper.adminGetCommisionRateListByCode(commisionRateCode);
		
		return commisionRateInfo;
	}
	
	
	/**
	 * 플랫폼 수수료율 추가
	 * @param commisionRate
	 */
	public void adminAddCommisionRate (CommisionRate commisionRate) {
		
		adminCommisionRateMapper.adminAddCommisionRate(commisionRate);
	}
	
	
	/**
	 * 플랫폼 수수료율 목록
	 * @return List<CommisionRate>
	 */
	public List<CommisionRate> adminGetCommisionRateList (){
		
		List<CommisionRate> adminGetCommisionRateList = adminCommisionRateMapper.adminGetCommisionRateList();
		
		return adminGetCommisionRateList;
	}
}
