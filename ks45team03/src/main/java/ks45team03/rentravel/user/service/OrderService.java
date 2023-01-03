package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.mapper.OrderMapper;

@Service
public class OrderService {
	
	//의존성 주입
	private final OrderMapper orderMapper;
	
	public OrderService(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}
	
	// 회원의 자신 주문 내역 조회
	public List<Rental> getUserOrderList(String userId){
		return orderMapper.getUserOrderList(userId);
	};
}
