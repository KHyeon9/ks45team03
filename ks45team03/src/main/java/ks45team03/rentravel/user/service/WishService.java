package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Wish;
import ks45team03.rentravel.mapper.WishMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WishService {
	
	private final WishMapper wishMapper;
	
	public List<Wish> getWishList(String loginId,int startIndex, int pageSize){
		
		List<Wish> wishList = wishMapper.getWishList(loginId,startIndex,pageSize);
		
		return wishList;
	}
	
	public int getWishListCount(String loginId) {
		
		int wishListCount = wishMapper.getWishListCount(loginId);
		
		return wishListCount;
	}
	
	public int addWish(String wishCode, String goodsCode, String loginId) {
		
		return wishMapper.addWish(wishCode, goodsCode, loginId);
	}
	
	public int checkWish(String goodsCode, String loginId) {
		
		return wishMapper.checkWish(goodsCode, loginId);
	}
	
	public int removeAlarmWish(String goodsCode, String loginId) {
		
		return wishMapper.removeAlarmWish(goodsCode, loginId);
	}
	
	public int removeWish(String goodsCode, String loginId) {
		
		return wishMapper.removeWish(goodsCode, loginId);
	}
}
