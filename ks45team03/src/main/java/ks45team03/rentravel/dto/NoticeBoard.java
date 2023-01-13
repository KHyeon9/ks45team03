package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeBoard {
	
	private String noticeBoardCode;
	private int num;
	private String userId;
	private String noticeBoardTitle;
	private String noticeBoardContent;
	private String noticeBoardFile;
	private String noticeBoardLikeCnt;
	private String noticeBoardViewCnt;
	private String noticeBoardRegTime;
}
