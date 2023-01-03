package ks45team03.rentravel.dto;

public class AlarmWish {

	private String alarmWishCode;
	private String wishCode;
	private String userId;
	private String goodsCode;
	private String alarmClickAddr;
	private String alarmSendTime;
	
	public String getAlarmWishCode() {
		return alarmWishCode;
	}
	public void setAlarmWishCode(String alarmWishCode) {
		this.alarmWishCode = alarmWishCode;
	}
	public String getWishCode() {
		return wishCode;
	}
	public void setWishCode(String wishCode) {
		this.wishCode = wishCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	
	public String getAlarmClickAddr() {
		return alarmClickAddr;
	}
	public void setAlarmClickAddr(String alarmClickAddr) {
		this.alarmClickAddr = alarmClickAddr;
	}
	public String getAlarmSendTime() {
		return alarmSendTime;
	}
	public void setAlarmSendTime(String alarmSendTime) {
		this.alarmSendTime = alarmSendTime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AlarmWish [alarmWishCode=");
		builder.append(alarmWishCode);
		builder.append(", wishCode=");
		builder.append(wishCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", alarmCilckaddr=");
		builder.append(alarmClickAddr);
		builder.append(", alarmSendTime=");
		builder.append(alarmSendTime);
		builder.append("]");
		return builder.toString();
	}
	
}
