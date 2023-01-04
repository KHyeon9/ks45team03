package ks45team03.rentravel.dto;

public class LoginInfo {
	
	private String loginId;
	private String loginNickName;
	private String loginLevelName;
	
	public LoginInfo() {}
	
	public LoginInfo(String loginId, String loginNickName, String loginLevelName) {
		this.loginId = loginId;
		this.loginNickName = loginNickName;
		this.loginLevelName = loginLevelName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginNickName() {
		return loginNickName;
	}

	public void setLoginNickName(String loginNickName) {
		this.loginNickName = loginNickName;
	}
	
	public String getLoginLevelName() {
		return loginLevelName;
	}

	public void setLoginLevelName(String loginLevelName) {
		this.loginLevelName = loginLevelName;
	}

	@Override
	public String toString() {
		return "LoginInfo [loginId=" + loginId + ", loginNickName=" + loginNickName + ", loginLevelName=" + loginLevelName + "]";
	}
}
