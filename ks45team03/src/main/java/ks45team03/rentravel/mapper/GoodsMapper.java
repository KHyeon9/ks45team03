package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.GoodsImg;

@Mapper
public interface GoodsMapper {
	
	public List<Goods> getGoodsListNotUser();
	
	public List<Goods> getGoodsList(String loginId);
	
	public List<GoodsImg> getGoodsImg(String goodsCode);
	
	public Goods getGoodsDetailByGoodsCode(String goodsCode);
	
	public int addGoods(Goods goods);
	
	public int modifyGoods(Goods goods);
}
