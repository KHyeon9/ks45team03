package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Wish;

@Mapper
public interface WishMapper {
	
	public List<Wish> getWishList(String loginId,int startIndex, int pageSize);
	
	public int getWishListCount(String loginId);
	
	public int addWish(String wishCode, String goodsCode, String loginId);
	
	public int checkWish(String goodsCode, String loginId);
	
	public int removeAlarmWish(String goodsCode, String loginId);
	
	public int removeWish(String goodsCode,String loginId);
}
