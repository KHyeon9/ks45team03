package ks45team03.rentravel.dto;

public class GoodsImg {
	private String goodsImgCode;
	private String goodsCode;
	private String goodsImg;
	private String imgRegDate;
	
	public String getGoodsImgCode() {
		return goodsImgCode;
	}
	public void setGoodsImgCode(String goodsImgCode) {
		this.goodsImgCode = goodsImgCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getImgRegDate() {
		return imgRegDate;
	}
	public void setImgRegDate(String imgRegDate) {
		this.imgRegDate = imgRegDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsImg [goodsImgCode=");
		builder.append(goodsImgCode);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", goodsImg=");
		builder.append(goodsImg);
		builder.append(", imgRegDate=");
		builder.append(imgRegDate);
		builder.append("]");
		return builder.toString();
	}
	
}
