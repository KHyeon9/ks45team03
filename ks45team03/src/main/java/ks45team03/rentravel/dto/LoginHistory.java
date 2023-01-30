package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginHistory {
	
	private int num;
	private String loginCode;
	private String userId;
	private String loginDate;
	private int dateDiff;
	
}
