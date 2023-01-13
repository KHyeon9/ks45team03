package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Goods;

@Mapper
public interface AdminGoodsMapper {
	public List<Goods> getAdminGoodsList();
	
	public int adminRemoveGoods(String goodsCode);
}
