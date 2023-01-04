package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.InfoBoardComment;

@Mapper
public interface InfoBoardMapper {
	
	// 정보 게시글 댓글 수정
	public int modifyInfoBoardComment(InfoBoardComment infoBoardComment);
	
	// 정보 게시글 댓글 삭제
	public int removeInfoBoardComment(String infoBoardCommentCode);
	
	// 장보 게시글 댓글 등록
	public int addInfoBoardComment(InfoBoardComment infoBoardComment);
	
	// 정보 게시글 등록
	public int addInfoBoard(InfoBoard infoBoard);
	
	// 정보 게시판 목록 조회
	public List<InfoBoard> getInfoBoardList(Map<String, Object> paramMap);
	
	// 정조 게시판 총 개수 조회
	public int getInfoBoardListCnt();
	
	// 정보 게시글 상세 조회
	public InfoBoard getInfoBoardDetail(String infoBoardCode);
	
	// 정보 게시글의 댓글 조회
	public List<InfoBoardComment> getInfoBoardComment(String infoBoardCode);
	
	// 댓글 갯수 조회
	public int getCommentCnt(String infoBoardCode);
}
