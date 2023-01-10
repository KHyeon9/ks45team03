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
	
	public List<Goods> getGoodsList(String loginId, int startIndex, int pageSize, String goodsCategoryCode,String searchKey, String searchValue, String goodsRentalAvailability){
		
		if(searchKey != null) {
			switch (searchKey) {
			case "goodsName":
				searchKey = "g.goods_name";
				break;
			case "userId":
				searchKey = "g.user_id";
				break;
			}
		}
		
		List<Goods> goodsList = goodsMapper.getGoodsList(loginId, startIndex, pageSize, goodsCategoryCode,searchKey,searchValue, goodsRentalAvailability);
		
		return goodsList;
	}
	
	public List<Goods> getGoodsListNotLogin(int startIndex, int pageSize, String goodsCategoryCode, String searchKey,String searchValue,String goodsRentalAvailability){
		
		if(searchKey != null) {
			switch (searchKey) {
			case "goodsName":
				searchKey = "g.goods_name";
				break;
			case "userId":
				searchKey = "g.user_id";
				break;
			}
		}		
		
		List<Goods> goodsList = goodsMapper.getGoodsListNotLogin(startIndex, pageSize,goodsCategoryCode,searchKey,searchValue,goodsRentalAvailability);
		
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
	
	public int getGoodsListCount(String goodsCategoryCode, String searchKey, String searchValue,String goodsRentalAvailability) {
		
		if(searchKey != null) {
			switch (searchKey) {
			case "goodsName":
				searchKey = "goods_name";
				break;
			case "userId":
				searchKey = "user_id";
				break;
			}
		}		
		
		int goodsListCount = goodsMapper.getGoodsListCount(goodsCategoryCode, searchKey, searchValue,goodsRentalAvailability);
		
		return goodsListCount;
	}
	
	public List<Goods> getGoodsListByGoodsCategory(String goodsCategoryCode){
		
		List<Goods> goodsListByGoodsCategory = goodsMapper.getGoodsListByGoodsCategory(goodsCategoryCode);
		
		return goodsListByGoodsCategory;
	}
	
	public List<Goods> getGoodsListByUserId(String userId){
		
		List<Goods> goodsListByUserId = goodsMapper.getGoodsListByUserId(userId);
		
		return goodsListByUserId;
	}
	
	public int removeGoods(String goodsCode) {
		
		return goodsMapper.removeGoods(goodsCode);
	}
	
	public List<Goods> getMyGoodsList(String loginId,int startIndex, int pageSize){
		
		List<Goods> myGoodsList = goodsMapper.getMyGoodsList(loginId,startIndex,pageSize);
		
		return myGoodsList;
	}
	
	public int getMyGoodsListCount(String loginId) {
		
		return goodsMapper.getMyGoodsListCount(loginId);
	}
}
