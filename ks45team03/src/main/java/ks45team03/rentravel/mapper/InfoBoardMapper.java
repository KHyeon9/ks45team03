package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.GoodsCategory;
import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.InfoBoardComment;

@Mapper
public interface InfoBoardMapper {
	
	// 파일 테이블 데이터 삭제
	public int removeFileData(List<String> fileCodeList);
	
	// 파일 그룹 테이블 데이터 삭제
	public int removeFileGroupData(String fileGroupCode);
	
	// 파일 코드 조회
	public List<String> getFileCodeByFeilGroupCode(String fileGroupCode);
	
	// 정보 게시판 사진 조회
	public List<String> getInfoBoardImgPath(String infoBoardCode);
	
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

	// 정보 게시판과 관련된 모든 댓글 삭제
	public int removeInfoBoardCommentAll(String infoBoardCode);
	
	// 정보 게시판과 관련된 모든 댓글 삭제
	public int removeInfoBoard(String infoBoardCode);
	
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
