package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.GoodsImg;

@Mapper
public interface GoodsMapper {
	
	public List<Goods> getGoodsListNotLogin(int startIndex, int pageSize);
	
	public List<Goods> getGoodsList(String loginId, int startIndex, int pageSize);
	
	public List<GoodsImg> getGoodsImg(String goodsCode);
	
	public Goods getGoodsDetailByGoodsCode(String goodsCode);
	
	public int addGoods(Goods goods);
	
	public int modifyGoods(Goods goods);
	
	public List<Goods> getGoodsCategoryAndCount();
	
	public int getGoodsListCount();
	
	public List<Goods> getGoodsListByGoodsCategory(String goodsCategoryCode);
}
