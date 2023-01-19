package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RemoveAccount {

	private int num;
	private String removeAccountCode;
	private String userId;
	private String removeAccountDate;
	private int dateDiff;
	
}
