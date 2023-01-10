package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Payment;
import ks45team03.rentravel.dto.RegionSgg;
import ks45team03.rentravel.dto.Rental;
import ks45team03.rentravel.dto.User;

@Mapper
public interface OrderMapper {
	
	
	// 마일리지 적립율 조회
	public float getUserSaveMileageRate(String userId);
	
	// 수수료율 조회
	public float getCommisionRate();
	
	// 그룹 코드 날짜 부분
	public String getGroupCodeDate(String date);
	
	// payment 등록
	public int addPayment(Payment payment);
	
	// 렌탈 등록
	public int addRental(Rental rental);
	
	// 시군구 불러오기
	public List<RegionSgg> getRegionSggBySidoCode(String regionSidoCode);
	
	// 로그인 아이디로 유저 주소 정보 조회
	public User loginUserInfo(String userId); 
	
	// 회원의 자신 주문 내역 조회
	public List<Rental> getUserOrderList(String userId);
	
}
