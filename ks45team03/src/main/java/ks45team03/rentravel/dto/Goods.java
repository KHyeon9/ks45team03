package ks45team03.rentravel.dto;

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
	
	private String goodsCategoryName;

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsCategoryCode() {
		return goodsCategoryCode;
	}

	public void setGoodsCategoryCode(String goodsCategoryCode) {
		this.goodsCategoryCode = goodsCategoryCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoodsRentalAvailability() {
		return goodsRentalAvailability;
	}

	public void setGoodsRentalAvailability(String goodsRentalAvailability) {
		this.goodsRentalAvailability = goodsRentalAvailability;
	}

	public int getGoodsValuePrice() {
		return goodsValuePrice;
	}

	public void setGoodsValuePrice(int goodsValuePrice) {
		this.goodsValuePrice = goodsValuePrice;
	}

	public String getGoodsPurchaseDate() {
		return goodsPurchaseDate;
	}

	public void setGoodsPurchaseDate(String goodsPurchaseDate) {
		this.goodsPurchaseDate = goodsPurchaseDate;
	}

	public int getGoodsDayPrice() {
		return goodsDayPrice;
	}

	public void setGoodsDayPrice(int goodsDayPrice) {
		this.goodsDayPrice = goodsDayPrice;
	}

	public String getCommisionRateCode() {
		return commisionRateCode;
	}

	public void setCommisionRateCode(String commisionRateCode) {
		this.commisionRateCode = commisionRateCode;
	}

	public double getCommisionRate() {
		return commisionRate;
	}

	public void setCommisionRate(double commisionRate) {
		this.commisionRate = commisionRate;
	}

	public int getGoodsCommisionDayPrice() {
		return goodsCommisionDayPrice;
	}

	public void setGoodsCommisionDayPrice(int goodsCommisionDayPrice) {
		this.goodsCommisionDayPrice = goodsCommisionDayPrice;
	}

	public String getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public String getGoodsRegDate() {
		return goodsRegDate;
	}

	public void setGoodsRegDate(String goodsRegDate) {
		this.goodsRegDate = goodsRegDate;
	}

	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}

	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [goodsCode=");
		builder.append(goodsCode);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", goodsCategoryCode=");
		builder.append(goodsCategoryCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", goodsRentalAvailability=");
		builder.append(goodsRentalAvailability);
		builder.append(", goodsValuePrice=");
		builder.append(goodsValuePrice);
		builder.append(", goodsPurchaseDate=");
		builder.append(goodsPurchaseDate);
		builder.append(", goodsDayPrice=");
		builder.append(goodsDayPrice);
		builder.append(", commisionRateCode=");
		builder.append(commisionRateCode);
		builder.append(", commisionRate=");
		builder.append(commisionRate);
		builder.append(", goodsCommisionDayPrice=");
		builder.append(goodsCommisionDayPrice);
		builder.append(", goodsDetail=");
		builder.append(goodsDetail);
		builder.append(", goodsRegDate=");
		builder.append(goodsRegDate);
		builder.append(", goodsCategoryName=");
		builder.append(goodsCategoryName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
