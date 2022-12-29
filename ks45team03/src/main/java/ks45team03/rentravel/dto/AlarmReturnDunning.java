package ks45team03.rentravel.dto;

public class AlarmReturnDunning {

	private String alarmReturnDunningCode;
	private String goodsCode;
	private String userId;
	private String rentalCode;
	private String alarmClickAddr;
	private String alarmSendTime;
	public String getAlarmReturnDunningCode() {
		return alarmReturnDunningCode;
	}
	public void setAlarmReturnDunningCode(String alarmReturnDunningCode) {
		this.alarmReturnDunningCode = alarmReturnDunningCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(String rentalCode) {
		this.rentalCode = rentalCode;
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
		builder.append("AlarmReturnDunning [alarmReturnDunningCode=");
		builder.append(alarmReturnDunningCode);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", rentalCode=");
		builder.append(rentalCode);
		builder.append(", alarmClickAddr=");
		builder.append(alarmClickAddr);
		builder.append(", alarmSendTime=");
		builder.append(alarmSendTime);
		builder.append("]");
		return builder.toString();
	}
	
}
