package ks45team03.rentravel.dto;

public class UserLevel {
	
	private String userLevelCode;
	private String userLevelName;
	private double userLevelRate;
	private int userRequiredExp;
	public String getUserLevelCode() {
		return userLevelCode;
	}
	public void setUserLevelCode(String userLevelCode) {
		this.userLevelCode = userLevelCode;
	}
	public String getUserLevelName() {
		return userLevelName;
	}
	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}
	public double getUserLevelRate() {
		return userLevelRate;
	}
	public void setUserLevelRate(double userLevelRate) {
		this.userLevelRate = userLevelRate;
	}
	public int getUserRequiredExp() {
		return userRequiredExp;
	}
	public void setUserRequiredExp(int userRequiredExp) {
		this.userRequiredExp = userRequiredExp;
	}
	@Override
	public String toString() {
		return "UserLevel [userLevelCode=" + userLevelCode + ", userLevelName=" + userLevelName + ", userLevelRate="
				+ userLevelRate + ", userRequiredExp=" + userRequiredExp + "]";
	}
}
