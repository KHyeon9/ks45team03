package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.Goods;
import ks45team03.rentravel.mapper.AdminGoodsMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminGoodsService {
	
	private final AdminGoodsMapper adminGoodsMapper;
	
	public List<Goods> getAdminGoodsList(String goodsState){
		
		List<Goods> adminGoodsList = adminGoodsMapper.getAdminGoodsList(goodsState);
		
		return adminGoodsList;
	}
	
	public int adminRemoveGoods(String goodsCode) {
		
		int adminRemoveGoods = adminGoodsMapper.adminRemoveGoods(goodsCode);
		
		return adminRemoveGoods;
	}
}
