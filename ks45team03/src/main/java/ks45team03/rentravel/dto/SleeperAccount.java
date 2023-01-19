package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SleeperAccount {
	
	private int num;
	private String sleeperAccountCode;
	private String userId;
	private int loginDate;
	private String lastLoginDate;

}
