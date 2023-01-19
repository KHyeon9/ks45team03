package ks45team03.rentravel.user.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Payment;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.RentalCancel;
import ks45team03.rentravel.dto.WaybillOwner;
import ks45team03.rentravel.dto.WaybillRenter;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.GoodsMapper;
import ks45team03.rentravel.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {
	
	//의존성 주입
	private final OrderMapper orderMapper;
	private final GoodsMapper goodsMapper;
	private final CommonNewCode commonNewCode;
	
	public OrderService(OrderMapper orderMapper, GoodsMapper goodsMapper, CommonNewCode commonNewCode) {
		this.orderMapper = orderMapper;
		this.goodsMapper = goodsMapper;
		this.commonNewCode = commonNewCode;
	}
	
	public int modifyPaymentState(String paymentCode, String tradeStateCode) {
		return orderMapper.modifyPaymentState(paymentCode, tradeStateCode);
	};
	
	// 오너 주문 취소 확인
	public int cancelCheckOwner(String paymentCode) {
		int result = 0;
		result += orderMapper.modifyPaymentState(paymentCode, "trade_status8");
		result += orderMapper.cancelCheckOwner(paymentCode);
		
		return result;
	};
	
	// 주문 취소 추가 프로세스
	public int rentalCancel(String paymentCode, String loginId) {
		int result = 0;
		
		RentalCancel rentalCancel = new RentalCancel();
		Rental cancelInfo = orderMapper.getCancelInfo(paymentCode);
		String cancelCode = commonNewCode.getCommonNewCode("tb_rental_cancel", "rental_cancel_code");
		String rentalCode = cancelInfo.getRentalCode();
		String rentalRefundWay = cancelInfo.getPayment().getPaymentType();
		int rentalRefundMoney = cancelInfo.getPayment().getSettlementAmount();
		int useMilege = cancelInfo.getPayment().getMileageUsePrice();
		int saveMilege = cancelInfo.getPayment().getSaveMileage();
		
		rentalCancel.setRentalCancelCode(cancelCode);
		rentalCancel.setCancelUserId(loginId);
		rentalCancel.setRentalCode(rentalCode);
		rentalCancel.setPaymentCode(paymentCode);
		rentalCancel.setRefundWay(rentalRefundWay);
		rentalCancel.setRefundMoney(rentalRefundMoney);
		rentalCancel.setMileageUsePrice(useMilege);
		rentalCancel.setSaveMileage(saveMilege);
		
		
		result += orderMapper.addRentalCancel(rentalCancel);
		orderMapper.modifyPaymentState(paymentCode, "trade_status7");
		
		
		return result;
	};
	
	// 렌터의 운송장 번호 추가
	public int addWaybillRenter(WaybillRenter waybillRenter, String paymentCode) {
		int result = 0;
		String waybillCode = commonNewCode.getCommonNewCode("tb_waybill_renter", "waybill_renter_code");
		waybillRenter.setWaybillRenterCode(waybillCode);
		
		result += orderMapper.addWaybillRenter(waybillRenter);
		result += orderMapper.modifyPaymentState(paymentCode, "trade_status5");
		
		return result;
	};
	
	// 오너 반납 직거래 완료
	public int directTransactionReturn(String paymentCode) {
		return orderMapper.modifyPaymentState(paymentCode, "trade_status6");
	}
	
	// 렌터 렌트 직거래 완료
	public int directTransactionOrder(String paymentCode) {
		return orderMapper.modifyPaymentState(paymentCode, "trade_status4");
	}
	
	// 오너의 운송장 번호 추가
	public int addWaybillOwner(WaybillOwner waybillOwner, String paymentCode) {
		int result = 0;
		String waybillCode = commonNewCode.getCommonNewCode("tb_waybill_owner", "waybill_owner_code");
		waybillOwner.setWaybillOwnerCode(waybillCode);
		
		result += orderMapper.addWaybillOwner(waybillOwner);
		result += orderMapper.modifyPaymentState(paymentCode, "trade_status3");
		return result;
	}
	
	// 결제
	public int addOrder(Rental rental) throws ParseException {
		
		int result =  0;
		
		Payment paymentInfo = rental.getPayment();
		
		// 계산에 필요한 값
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = format.parse(rental.getRentalStartDate());
		Date endDate = format.parse(rental.getRentalEndDate());
		long dayGap = (endDate.getTime() - startDate.getTime()) /  86400000;
		float commisionRate = orderMapper.getCommisionRate();
		float saveMileageRate = orderMapper.getUserSaveMileageRate(rental.getUserId());
		int goodsDayPrice = goodsMapper.getGoodsDetailByGoodsCode(rental.getGoodsCode()).getGoodsDayPrice();
		
		// 계산 부분
		int expectedPaymentAmount = (int) (goodsDayPrice * dayGap); 
		int commisionTotalPrice = (int) (expectedPaymentAmount * commisionRate);
		int amountExcludingMileage = expectedPaymentAmount - paymentInfo.getMileageUsePrice();
		int saveMileage = (int) (amountExcludingMileage * saveMileageRate);
		int settlementAmount = expectedPaymentAmount - commisionTotalPrice;
		
		result += orderMapper.addRental(rental);
		
		String groupCodeDate =  orderMapper.getGroupCodeDate(rental.getRentalCode());
		String milegeUseGroupCode = rental.getUserId() + "_결제완료_적립금_사용_" + groupCodeDate;
		String milegeSaveGroupCode = rental.getUserId() + "_결제완료_적립금_적립_" + groupCodeDate;
		
		paymentInfo.setGoodsCode(rental.getGoodsCode());
		paymentInfo.setRentalCode(rental.getRentalCode());
		paymentInfo.setExpectedPaymentAmount(expectedPaymentAmount);
		paymentInfo.setGoodsCommisionTotalPrice(commisionTotalPrice);
		paymentInfo.setAmountExcludingMileage(amountExcludingMileage);
		paymentInfo.setSaveMileage(saveMileage);
		paymentInfo.setSettlementAmount(settlementAmount);
		paymentInfo.setTradeStatusCode("trade_status1");
		paymentInfo.setMileageUseGroupCode(milegeUseGroupCode);
		paymentInfo.setMileageSaveGroupCode(milegeSaveGroupCode);
		
		result += orderMapper.addPayment(paymentInfo);
		
		return result;
	}
	
	// 회원의 자신 렌트 물품 정보 조회
	public Rental getRentalGoodsInfo(String rentalCode) {
		return orderMapper.getRentalGoodsInfo(rentalCode);
	};
	
	// 회원의 자신 렌트 내역 조회
	public List<Rental> getUserRentList(String userId, int startIndex, int pageSize){
		return orderMapper.getUserRentalList(userId, startIndex, pageSize);
	};
	
	// 회원의 자신 주문 내역 조회
	public List<Rental> getUserOrderList(String userId, int startIndex, int pageSize){
		return orderMapper.getUserOrderList(userId, startIndex, pageSize);
	};
}
