package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.RentalCancel;

@Mapper
public interface AdminOrderMapper {
	
	// 주문 내역 조회
	public List<Rental> getOrderHistory();
	
	// 주문 내역 행 갯수 조회
	public int getOrderHistoryCnt();
	
	// 주문 취소 내역 조회
	public List<RentalCancel> getRentalCancelHistory();
}
