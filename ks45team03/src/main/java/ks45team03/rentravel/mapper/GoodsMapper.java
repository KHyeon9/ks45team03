package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.GoodsImg;

@Mapper
public interface GoodsMapper {
	
	public List<Goods> getGoodsList();
	
	public List<GoodsImg> getGoodsImg(String goodsCode);
}
