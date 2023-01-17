package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Review {
	private String reviewCode;
	private String goodsCode;
	private String userId;
	private String reviewContent;
	private String goodsEvaluation;
	private String reviewImg;
	private String reviewRegDate;
	private String mileageGroupCode;
	private String saveMileage;
	
	private String goodsName;

	private int checkReviewCount;
	
	private User user;

}
