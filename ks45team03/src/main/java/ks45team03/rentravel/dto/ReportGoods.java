package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReportGoods {

	private String reportGoodsCode;
	private String reportTypeCode;
	private String goodsCode;
	private String reportStateCode;
	private String reportingUserId;
	private String reportedUserId;
	private String reportGoodsDateTime;
	
	ReportState reportState;
	ReportType reportType;
}
