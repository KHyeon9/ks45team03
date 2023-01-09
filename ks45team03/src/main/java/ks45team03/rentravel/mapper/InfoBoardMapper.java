package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.GoodsCategory;
import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.InfoBoardComment;

@Mapper
public interface InfoBoardMapper {
	
	// 상품 카테고리 조회
	public List<GoodsCategory> getGoodsCategory();
	
	// 조회수 증가 처리
	public int viewIncrease(String infoBoardCode);
	
	// 정보 게시글 댓글 수정
	public int modifyInfoBoardComment(InfoBoardComment infoBoardComment);
	
	// 정보 게시글 댓글 삭제
	public int removeInfoBoardComment(String infoBoardCommentCode);
	
	// 장보 게시글 댓글 등록
	public int addInfoBoardComment(InfoBoardComment infoBoardComment);

	// 정보 게시글 수정
	public int modifyInfoBoard(InfoBoard infoBoard);
	
	// 정보 게시글 등록
	public int addInfoBoard(InfoBoard infoBoard);
	
	// 정보 게시판 목록 조회
	public List<InfoBoard> getInfoBoardList(int startIndex, int pageSize);
	
	// 정보 게시판 총 개수 조회
	public int getInfoBoardListCnt();
	
	// 정보 게시글 상세 조회
	public InfoBoard getInfoBoardDetail(String infoBoardCode);
	
	// 정보 게시글의 댓글 조회
	public List<InfoBoardComment> getInfoBoardComment(String infoBoardCode, int startIndex, int pageSize);
	
	// 댓글 갯수 조회
	public int getCommentCnt(String infoBoardCode);
}
