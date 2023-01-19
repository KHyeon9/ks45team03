package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Payment;
import ks45team03.rentravel.dto.RegionSgg;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.RentalCancel;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.dto.WaybillOwner;
import ks45team03.rentravel.dto.WaybillRenter;

@Mapper
public interface OrderMapper {
	
	// 오너 주문 취소 확인
	public int cancelCheckOwner(String paymentCode);
	
	// 주문 취소 등록
	public int addRentalCancel(RentalCancel rentalCancel);
	
	// 주문 취소 정보 조회
	public Rental getCancelInfo(String paymentCode);
	
	// 렌터의의 주문 물품 배송 정보 조회
	public WaybillOwner getOrderDeliveryInfo(String userId, String paymentCode);
	
	// 오너의 대여 물품 배송 정보 조회
	public WaybillRenter getRentDeliveryInfo(String userId, String paymentCode);
	
	// 렌터 주문 횟수
	public int getUserOrderCnt(String userId);
	
	// 렌터 운송장 번호 추가
	public int addWaybillRenter(WaybillRenter waybillRenter);
	
	// 오너 렌트 횟수
	public int getUserRentCnt(String userId);
	
	// 오너 운송장 번호 추가
	public int addWaybillOwner(WaybillOwner waybillOwner);
	
	// 상품 결제 상태 업데이트
	public int modifyPaymentState(String paymentCode, String tradeStateCode);
	
	// 마일리지 적립율 조회
	public float getUserSaveMileageRate(String userId);
	
	// 수수료율 조회
	public float getCommisionRate();
	
	// 그룹 코드 날짜 부분
	public String getGroupCodeDate(String rentalCode);
	
	// payment 등록
	public int addPayment(Payment payment);
	
	// 렌탈 등록
	public int addRental(Rental rental);
	
	// 시군구 불러오기
	public List<RegionSgg> getRegionSggBySidoCode(String regionSidoCode);
	
	// 로그인 아이디로 유저 주소 정보 조회
	public User loginUserInfo(String userId); 
	
	// 회원 주문 물품 정보 조회
	public Rental getOrderGoodsInfo(String rentalCode);
	
	// 회원의 렌트 물품 정보 조회
	public Rental getRentalGoodsInfo(String rentalCode);
	
	// 회원은 렌트 내역을 조회
	public List<Rental> getUserRentalList(String userId, int startIndex, int pageSize);
	
	// 회원의 자신 주문 내역 조회
	public List<Rental> getUserOrderList(String userId, int startIndex, int pageSize);
	
}
