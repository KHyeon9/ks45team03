package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.GoodsImg;
import ks45team03.rentravel.mapper.GoodsMapper;

@Service
public class GoodsService {
	
	private final GoodsMapper goodsMapper;
	
	public GoodsService(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	
	public List<Goods> getGoodsList(){
		
		List<Goods> goodsList = goodsMapper.getGoodsList();
		
		return goodsList;
	}
	
	public List<GoodsImg> getGoodsImg(String goodsCode){
		
		List<GoodsImg> goodsImg = goodsMapper.getGoodsImg(goodsCode);
		
		return goodsImg;
	}
}
