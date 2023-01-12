package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Wish {
	private String wishCode;
	private String userId;
	private String goodsCode;
	private String wishExpirationPeriodStart;
	private String wishExpirationPeriodEnd;
	
	private Goods goods;
}
