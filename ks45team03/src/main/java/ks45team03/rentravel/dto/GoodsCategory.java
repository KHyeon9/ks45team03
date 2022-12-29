package ks45team03.rentravel.dto;

public class GoodsCategory {
	private String goodsCategoryCode;
	private String goodsCategoryName;
	
	public String getGoodsCategoryCode() {
		return goodsCategoryCode;
	}
	public void setGoodsCategoryCode(String goodsCategoryCode) {
		this.goodsCategoryCode = goodsCategoryCode;
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
		builder.append("GoodsCategory [goodsCategoryCode=");
		builder.append(goodsCategoryCode);
		builder.append(", goodsCategoryName=");
		builder.append(goodsCategoryName);
		builder.append("]");
		return builder.toString();
	}
	
}
