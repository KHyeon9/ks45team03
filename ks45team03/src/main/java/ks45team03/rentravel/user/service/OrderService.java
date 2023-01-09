package ks45team03.rentravel.user.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Payment;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.mapper.AdminCommisionRateMapper;
import ks45team03.rentravel.mapper.AdminOrderMapper;
import ks45team03.rentravel.mapper.GoodsMapper;
import ks45team03.rentravel.mapper.OrderMapper;

@Service
public class OrderService {
	
	//의존성 주입
	private final OrderMapper orderMapper;
	private final GoodsMapper goodsMapper;
	
	public OrderService(OrderMapper orderMapper, GoodsMapper goodsMapper) {
		this.orderMapper = orderMapper;
		this.goodsMapper = goodsMapper;
	}

	// 결제
	public String addPayment(Rental rental) throws ParseException {
		
		orderMapper.addRental(rental);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = format.parse(rental.getRentalStartDate());
		Date endDate = format.parse(rental.getRentalEndDate());
		long dayGap = (endDate.getTime() - startDate.getTime()) /  (24*60*60);
		float commisionRate = orderMapper.getCommisionRate();
		float saveMileageRate = orderMapper.getUserSaveMileageRate(rental.getUserId());
		int goodsDayPrice = goodsMapper.getGoodsDetailByGoodsCode(rental.getGoodsCode()).getGoodsDayPrice();
		int totalPrice = (int) (goodsDayPrice * dayGap); 
		int commisionTotalPrice = (int) (totalPrice * commisionRate);
		int amountExcludingMileage = totalPrice - rental.getPayment().getMileageUsePrice();
		int saveMileage = (int) (amountExcludingMileage * saveMileageRate);
		int settlementAmount = (int) (totalPrice - commisionRate);
		String groupCodeDate =  orderMapper.getGroupCodeDate(rental.getRentalCode());
		String milegeUseGroupCode = rental.getUserId() + "_결제완료_적립금_사용_" + groupCodeDate;
		String milegeSaveGroupCode = rental.getUserId() + "_결제완료_적립금_적립_" + groupCodeDate;
		
		return null;
	}
	
	// 회원의 자신 주문 내역 조회
	public List<Rental> getUserOrderList(String userId){
		return orderMapper.getUserOrderList(userId);
	};
}
