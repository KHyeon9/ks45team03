package ks45team03.rentravel.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.CommisionRate;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.RentalCancel;
import ks45team03.rentravel.dto.Return;
import ks45team03.rentravel.dto.WaybillOwner;
import ks45team03.rentravel.dto.WaybillRenter;
import ks45team03.rentravel.mapper.AdminOrderMapper;

@Service
@Transactional
public class AdminOrderService {
	
	// 의존성 주입
	private AdminOrderMapper adminOrderMapper;
	
	public AdminOrderService(AdminOrderMapper adminOrderMapper) {
		this.adminOrderMapper = adminOrderMapper;
	}
	
	// 주문 내역 수정
	public int modifyOrderInfo (Rental rentalInfo) {
		
		int result = adminOrderMapper.modifyRentalTable(rentalInfo);
		result += adminOrderMapper.modifyPaymentTable(rentalInfo);
		
		return result;
	}
	
	// 오너 운송장번호 내역 조회
	public List<WaybillOwner> getWaybillOwners() {
		return adminOrderMapper.getWaybillOwnerList();
	}
	
	// 렌터 운송장번호 내역 조회
	public List<WaybillRenter> getWaybillRenters() {
		return adminOrderMapper.getWaybillRenterList();
	}
	
	// 주문 환불 내역 조회
	public List<Return> getReturnList() {
		return adminOrderMapper.getReturnList();
	}
	
	
	// 주문 취소 내역 조회
	public Map<String, Object> getRentalCancelHistory(int currentPage) {
		
		// 보여질 행의 개수
		int rowPerPage = 10;
		
		// 보여질 행의 시작점
		int startRowNum = (currentPage - 1)*rowPerPage;
		
		// 마지막페이지 
		// 테이블의 전체 행의 갯수
		double rowCnt = adminOrderMapper.getRentalCancelHistoryCnt();
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
		
		// 주문 목록 data
		List<RentalCancel> rentalCancelHistory = adminOrderMapper.getRentalCancelHistory(paramMap);
		
		// controller에 전달하기 위한 파라미터 셋팅
		paramMap.clear();
		paramMap.put("rentalCancelHistory", rentalCancelHistory);
		paramMap.put("lastPage", lastPage);
		paramMap.put("startPageNum", startPageNum);
		paramMap.put("endPageNum", endPageNum);
		paramMap.put("nextPage", nextPage);
		paramMap.put("prevPage", prevPage);
		
		return paramMap;
	}
	
	// 주문 내역 조회
	public Map<String, Object> getOrderHistory(int currentPage) {
		
		// 보여질 행의 개수
		int rowPerPage = 10;
		
		// 보여질 행의 시작점
		int startRowNum = (currentPage - 1)*rowPerPage;
		
		// 마지막페이지 
		// 테이블의 전체 행의 갯수
		double rowCnt = adminOrderMapper.getOrderHistoryCnt();
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
		
		// 주문 목록 data
		List<Rental> orderHistory = adminOrderMapper.getOrderHistory(paramMap);
		
		// controller에 전달하기 위한 파라미터 셋팅
		paramMap.clear();
		paramMap.put("orderHistory", orderHistory);
		paramMap.put("lastPage", lastPage);
		paramMap.put("startPageNum", startPageNum);
		paramMap.put("endPageNum", endPageNum);
		paramMap.put("nextPage", nextPage);
		paramMap.put("prevPage", prevPage);
		
		return paramMap;
	}

}
