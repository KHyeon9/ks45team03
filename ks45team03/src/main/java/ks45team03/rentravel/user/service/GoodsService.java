package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Block;
import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.dto.GoodsImg;
import ks45team03.rentravel.mapper.GoodsMapper;

@Service
public class GoodsService {
	
	private final GoodsMapper goodsMapper;
	
	public GoodsService(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	
	public List<Goods> getGoodsList(String loginId, int startIndex, int pageSize){
		
		List<Goods> goodsList = goodsMapper.getGoodsList(loginId, startIndex, pageSize);
		
		return goodsList;
	}
	
	public List<GoodsImg> getGoodsImg(String goodsCode){
		
		List<GoodsImg> goodsImg = goodsMapper.getGoodsImg(goodsCode);
		
		return goodsImg;
	}
	
	public Goods getGoodsDetailByGoodsCode(String goodsCode) {
		
		Goods goodsDetail = goodsMapper.getGoodsDetailByGoodsCode(goodsCode);
		
		return goodsDetail;
	}
	
	public int addGoods(Goods goods) {
		
		return goodsMapper.addGoods(goods);
	}
	
	public int modifyGoods(Goods goods) {
		
		return goodsMapper.modifyGoods(goods);
	}
	
	public List<Goods> getGoodsCategoryAndCount(){
		
		List<Goods> goodsCategoryAndCount = goodsMapper.getGoodsCategoryAndCount();
		
		return goodsCategoryAndCount;
	}
	
	public int getGoodsListCount() {
		
		int goodsListCount = goodsMapper.getGoodsListCount();
		
		return goodsListCount;
	}
	
	public List<Goods> getGoodsListByGoodsCategory(String goodsCategoryCode){
		
		List<Goods> goodsListByGoodsCategory = goodsMapper.getGoodsListByGoodsCategory(goodsCategoryCode);
		
		return goodsListByGoodsCategory;
		
		
	}
}
