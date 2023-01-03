package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.RentalCancel;
import ks45team03.rentravel.dto.Return;
import ks45team03.rentravel.dto.WaybillOwner;
import ks45team03.rentravel.dto.WaybillRenter;

@Mapper
public interface AdminOrderMapper {
	
	// 주문 내역 조회
	public List<Rental> getOrderHistory(Map<String, Object> paramMap);
	
	// 주문 내역 행 갯수 조회
	public int getOrderHistoryCnt();
	
	// 주문 취소 내역 조회
	public List<RentalCancel> getRentalCancelHistory(Map<String, Object> paramMap);
	
	// 주문 취소 내역 행 갯수 조회
	public int getRentalCancelHistoryCnt();
	
	// 주문 환불 내역 조회
	public List<Return> getReturnList();
	
	// 오더 운송자 번호 관리
	public List<WaybillOwner> getWaybillOwnerList();
	
	// 렌터 운송장 번호 관리
	public List<WaybillRenter> getWaybillRenterList();
	
	// 주문 수정 폼 정보 조회
	public Rental getOrderInfoByRentalCode(String rentalCode);
	
	// 주문 수정 렌탈 테이블
	public int modifyRentalTable(Rental rentalInfo);
	
	// 주문 수정 페이먼트 테이블
	public int modifyPaymentTable(Rental rentalInfo);
	
}
