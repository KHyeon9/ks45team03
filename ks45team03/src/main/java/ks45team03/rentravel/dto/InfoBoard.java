package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InfoBoard {
	private String infoBoardCode;
	private String userId;
	private String infoBoardTitle;
	private String infoBoardContent;
	private int infoBoardLikeCnt;
	private int infoBoardViewCnt;
	private String infoBoardRegTime;
	private User user;
	private int commentCnt;
	
}
