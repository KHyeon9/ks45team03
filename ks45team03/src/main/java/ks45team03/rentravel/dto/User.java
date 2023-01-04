package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
	
	private RegionSgg regionSgg;
}