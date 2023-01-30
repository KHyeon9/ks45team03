package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Goods {
	private String goodsCode;
	private String goodsName;
	private String goodsCategoryCode;
	private String userId;
	private String goodsRentalAvailability;
	private int goodsValuePrice;
	private String goodsPurchaseDate;
	private int goodsDayPrice;
	private String commisionRateCode;
	private double commisionRate;
	private int goodsCommisionDayPrice;
	private String goodsDetail;
	private String goodsRegDate;
	private String goodsState;
	private String fileGroupCode;
	
	private String filePath;
	
	private String regionSggCode;
	
	private String countByCategory;
	
	
	private String goodsCategoryName;
	
	private String userRegion;
	
	private String userNickname;

	
}
