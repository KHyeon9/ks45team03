package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Rental;

@Mapper
public interface OrderMapper {
	
	// 회원의 자신 주문 내역 조회
	public List<Rental> getUserOrderList(String userId);
	
}
