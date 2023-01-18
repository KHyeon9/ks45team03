package ks45team03.rentravel.admin.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import ks45team03.rentravel.mapper.OrderMapper;

@Service
@Transactional
public class AdminOrderService {
	
	// 의존성 주입
	private AdminOrderMapper adminOrderMapper;
	private OrderMapper orderMapper;
	
	public AdminOrderService(AdminOrderMapper adminOrderMapper, OrderMapper orderMapper) {
		this.adminOrderMapper = adminOrderMapper;
		this.orderMapper = orderMapper;
	}
	
	// 환불 확인
	public int checkRefound(RentalCancel rentalCancel) {
		int result = 0;
		
		Date nowDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String nowDateStr = simpleDateFormat.format(nowDate);
		
		String cancelGroupCode = nowDateStr + "_환불_완료_적립금_" + rentalCancel.getCancelUserId();
		
		rentalCancel.setMileageGroupCode(cancelGroupCode);
		
		System.out.println(rentalCancel + " => rentalCancel Info ~~~~~~~~~~~~~~~~~~~~~");
		
		result += orderMapper.modifyPaymentState(rentalCancel.getPaymentCode(), "trade_status2");
		result += adminOrderMapper.checkRefound(rentalCancel);
		
		
		return result;
	};
	
	// 주문 내역 수정
	public int modifyOrderInfo (Rental rentalInfo) {
		
		int result = adminOrderMapper.modifyRentalTable(rentalInfo);
		result += adminOrderMapper.modifyPaymentTable(rentalInfo);
		
		return result;
	}
	
	// 오너 운송장번호 내역 조회
	public List<WaybillOwner> getWaybillOwners(int startIndex, int pageSize) {
		return adminOrderMapper.getWaybillOwnerList(startIndex, pageSize);
	}
	
	// 렌터 운송장번호 내역 조회
	public List<WaybillRenter> getWaybillRenters(int startIndex, int pageSize) {
		return adminOrderMapper.getWaybillRenterList(startIndex, pageSize);
	}
	
	// 주문 반납 내역 조회
	public List<Return> getReturnHistory(int startIndex, int pageSize) {
		return adminOrderMapper.getReturnHistory(startIndex, pageSize);
	}
	
	// 주문 반납 수정 폼 조회
	public Return getReturn(String returnCode) {
		return adminOrderMapper.getReturn(returnCode);
	}
	
	// 주문 반납 수정
	public int modifyReturn (Return returnInfo) {
		return adminOrderMapper.modifyReturn(returnInfo);
	}
	
	// 주문 취소 내역 조회
	public List<RentalCancel> getRentalCancelHistory(int startIndex, int pageSize) {
		return adminOrderMapper.getRentalCancelHistory(startIndex, pageSize);
	}
	
	// 주문 취소 정보 주문 취소 코드로 조회
	public  RentalCancel getRentalCancel(String rentalCancelCode) {
		return adminOrderMapper.getRentalCancel(rentalCancelCode);
	}
	
	// 주문 취소 정보 수정
	public int modifyRentalCancel(RentalCancel rentalCancel) {
		return adminOrderMapper.modifyRentalCancel(rentalCancel);
	};
	
	// 주문 내역 조회
	public List<Rental> getOrderHistory(int startIndex, int pageSize) {
		return adminOrderMapper.getOrderHistory(startIndex, pageSize);
	}

}
