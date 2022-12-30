package ks45team03.rentravel.dto;

public class LoginHistory {
	
	private String loginCode;
	private String userId;
	private String loginDate;
	private String logoutDate;
	
	public String getLoginCode() {
		return loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public String getLogoutDate() {
		return logoutDate;
	}
	public void setLogoutDate(String logoutDate) {
		this.logoutDate = logoutDate;
	}
	@Override
	public String toString() {
		return "LoginHistory [loginCode=" + loginCode + ", userId=" + userId + ", loginDate=" + loginDate
				+ ", logoutDate=" + logoutDate + "]";
	}
}
