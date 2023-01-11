package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FAQ {
	
	private String faqBoardCode;
	private String userId;
	private String faqBoardCategoryCode;
	private String faqBoardCategoryName;
	private String userNickName;
	private String faqBoardTitle;
	private String faqBoardContent;
	private String faqBoardRegTime;
	private String faqBoardFrequently;
}
