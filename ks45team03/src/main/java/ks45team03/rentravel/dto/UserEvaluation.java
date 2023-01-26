package ks45team03.rentravel.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEvaluation {

	private int num;
	private int countEvaluationType;
	
	private String userEvaluationCode;
	private String userId;
	private String evaluatedUserId;
	private String userEvaluationTypeCode;
	private String userEvaluationTypeName;
	private String userEvaluationDate;
	
	private List<String> userEvaluationTypeCodeList;
}
