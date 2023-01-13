package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.RentalCancel;
import ks45team03.rentravel.dto.Return;
import ks45team03.rentravel.dto.TradeStatus;
import ks45team03.rentravel.dto.WaybillOwner;
import ks45team03.rentravel.dto.WaybillRenter;

@Mapper
public interface AdminOrderMapper {
	
	
	// 주문 상태 조회
	public List<TradeStatus> getTradeStateList();
	
	// 주문 내역 조회
	public List<Rental> getOrderHistory(int startIndex, int pageSize);
	
	// 주문 내역 행 갯수 조회
	public int getOrderHistoryCnt();
	
	// 주문 취소 내역 조회
	public List<RentalCancel> getRentalCancelHistory(int startIndex, int pageSize);
	
	// 주문 취소 내역 행 갯수 조회
	public int getRentalCancelHistoryCnt();
	
	// 주문 취소 내역 주문 취소 코드로 정보 조회
	public RentalCancel getRentalCancel(String rentalCancelCode);
	
	// 주문 취소 정보 수정
	public int modifyRentalCancel(RentalCancel rentalCancel);
	
	// 주문 반납 내역 조회
	public List<Return> getReturnHistory(int startIndex, int pageSize);
	
	// 주문 반납 수정 폼 조회
	public Return getReturn(String returnCode);
	
	// 반납 정보 수정
	public int modifyReturn(Return returnInfo);
	
	// 오너 운송장 번호 조회
	public WaybillOwner getOwnerWayBill(String waybillOwnerCode);
	
	// 오너 운송장 번호 관리
	public List<WaybillOwner> getWaybillOwnerList(int startIndex, int pageSize);
	
	// 오너 운송장 번호 수정
	public int modifyWaybillOwner(WaybillOwner waybillOwner);
	
	// 오너 운송장 번호 갯수 조회
	public int getOwnerWaybillCnt();
	
	// 렌터 운송장 번호 조회
	public WaybillRenter getRenterWayBill(String waybillRenterCode);
	
	// 렌터 운송장 번호 관리
	public List<WaybillRenter> getWaybillRenterList(int startIndex, int pageSize);
	
	// 렌터 운송장 번호 수정
	public int modifyWaybillRenter(WaybillRenter waybillRenter);
	
	// 렌터 운송장 번호 갯수 조회
	public int getRenterWaybillCnt();
	
	// 주문 수정 폼 정보 조회
	public Rental getOrderInfoByRentalCode(String rentalCode);
	
	// 주문 수정 렌탈 테이블
	public int modifyRentalTable(Rental rentalInfo);
	
	// 주문 수정 페이먼트 테이블
	public int modifyPaymentTable(Rental rentalInfo);
	
}
