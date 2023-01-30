package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.GoodsImg;

@Mapper
public interface GoodsMapper {
	
	public List<Goods> getGoodsListNotLogin(int startIndex, int pageSize, String goodsCategoryCode,String searchKey, String searchValue, String goodsRentalAvailability);

	public List<Goods> getMainGoodsList();
	
	public List<Goods> getGoodsList(String loginId, int startIndex, int pageSize, String goodsCategoryCode,String searchKey, String searchValue, String goodsRentalAvailability);
	
	public List<GoodsImg> getGoodsImg(String goodsCode);
	
	public Goods getGoodsDetailByGoodsCode(String goodsCode);
	
	public int addGoods(Goods goods);
	
	public int modifyGoods(Goods goods);
	
	public List<Goods> getGoodsCategoryAndCount();
	
	public int getGoodsListCount(String goodsCategoryCode, String searchKey, String searchValue, String goodsRentalAvailability);
	
	public List<Goods> getGoodsListByGoodsCategory(String goodsCategoryCode);
	
	public List<Goods> getGoodsListByUserId(String userId, String goodsCode);
	
	public int removeGoods(String goodsCode);
	
	public List<Goods> getMyGoodsList(String loginId,int startIndex, int pageSize);
	
	public int getMyGoodsListCount(String loginId);
	
	public List<Goods> getMyGoodsList2(String userNickName,int startIndex, int pageSize);
	
	public int getMyGoodsListCount2(String userNickName);
	
	public List<Goods> getGoodsListImg();
	
	public List<Goods> getGoodsCategoryListForGoods();
	
	public String getLoginUserRegion(String loginId);
}
