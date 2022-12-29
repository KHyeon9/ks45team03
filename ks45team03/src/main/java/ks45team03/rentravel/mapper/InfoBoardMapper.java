package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.InfoBoardComment;

@Mapper
public interface InfoBoardMapper {
	
	// 정보 게시판 목록 조회
	public List<InfoBoard> getInfoBoardList(Map<String, Object> paramMap);
	
	// 정보 게시판 총 개수 조회
	public int getInfoBoardListCnt();
	
	// 정보 게시글 상세 조회
	public InfoBoard getInfoBoardDetail(String userId);
	
	// 정보 게시글의 댓글 조회
	public InfoBoardComment getInfoBoardComment(String uesrId);
}
