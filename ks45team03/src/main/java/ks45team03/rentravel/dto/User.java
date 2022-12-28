package ks45team03.rentravel.dto;

public class User {
	
	private String userId;
	private String userPw;
	private String userName;
	private String userNickName;
	private String userLevelCode;
	private String userLevelName;
	private String userEmail;
	private String userPhoneNumber;
	private String userImage;
	private int totalExp;
	private String regionSggCode;
	private String userAddrDesc;
	private String region;
	private int totalMileage;
	private String userCreateDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public int getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}
	public String getRegionSggCode() {
		return regionSggCode;
	}
	public void setRegionSggCode(String regionSggCode) {
		this.regionSggCode = regionSggCode;
	}
	public String getUserAddrDesc() {
		return userAddrDesc;
	}
	public void setUserAddrDesc(String userAddrDesc) {
		this.userAddrDesc = userAddrDesc;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getTotalMileage() {
		return totalMileage;
	}
	public void setTotalMileage(int totalMileage) {
		this.totalMileage = totalMileage;
	}
	public String getUserCreateDate() {
		return userCreateDate;
	}
	public void setUserCreateDate(String userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userNickName="
				+ userNickName + ", userLevelCode=" + userLevelCode + ", userLevelName=" + userLevelName
				+ ", userEmail=" + userEmail + ", userPhoneNumber=" + userPhoneNumber + ", userImage=" + userImage
				+ ", totalExp=" + totalExp + ", regionSggCode=" + regionSggCode + ", userAddrDesc=" + userAddrDesc
				+ ", region=" + region + ", totalMileage=" + totalMileage + ", userCreateDate=" + userCreateDate + "]";
	}
}