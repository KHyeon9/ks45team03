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
	public List<WaybillOwner> getWaybillOwners(int startIndex, int pageSize) {
		return adminOrderMapper.getWaybillOwnerList(startIndex, pageSize);
	}
	
	// 렌터 운송장번호 내역 조회
	public List<WaybillRenter> getWaybillRenters(int startIndex, int pageSize) {
		return adminOrderMapper.getWaybillRenterList(startIndex, pageSize);
	}
	
	// 주문 환불 내역 조회
	public List<Return> getReturnHistory(int startIndex, int pageSize) {
		return adminOrderMapper.getReturnHistory(startIndex, pageSize);
	}
	
	
	// 주문 취소 내역 조회
	public List<RentalCancel> getRentalCancelHistory(int startIndex, int pageSize) {
		return adminOrderMapper.getRentalCancelHistory(startIndex, pageSize);
	}
	
	// 주문 내역 조회
	public List<Rental> getOrderHistory(int startIndex, int pageSize) {
		return adminOrderMapper.getOrderHistory(startIndex, pageSize);
	}

}
