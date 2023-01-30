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
	private String userEmailId;
	private String userEmailAddr;
	private String userPhoneNumber;
	private String userFirstPhoneNumber;
	private String userMiddlePhoneNumber;
	private String userLastPhoneNumber;
	private String userImage;
	private int totalExp;
	private String regionSggCode;
	private String regionSggName;
	private String regionSidoCode;
	private String regionSidoName;
	private String userAddrDesc;
	private String region;
	private int totalMileage;
	private String userCreateDate;
	private String userWithdrawal;
	
	private RegionSgg regionSgg;
	private RegionSido regionSido;
}