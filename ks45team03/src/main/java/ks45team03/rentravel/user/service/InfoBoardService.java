package ks45team03.rentravel.user.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.InfoBoardComment;
import ks45team03.rentravel.mapper.InfoBoardMapper;

@Service
@Transactional
public class InfoBoardService{
	// 의존성 주입
	private final InfoBoardMapper infoBoardMapper;
	
	
	public InfoBoardService(InfoBoardMapper infoBoardMapper) {
		this.infoBoardMapper = infoBoardMapper;
	}
	
	// 조회수 증가 처리
	public int viewIncrease(String infoBoardCode) {
		return infoBoardMapper.viewIncrease(infoBoardCode);
	}
	
	// 게시글 댓글 수정
	public int modifyInfoBoardComment(InfoBoardComment infoBoardComment) {
		return infoBoardMapper.modifyInfoBoardComment(infoBoardComment);
	}
	
	// 게시글 댓글 삭제
	public int removeInfoBoardComment(String infoBoardCommentCode) {
		return infoBoardMapper.removeInfoBoardComment(infoBoardCommentCode);
	}
	
	// 게시글 댓글 등록
	public int  addInfoBoardComment(InfoBoardComment infoBoardComment) {
		return infoBoardMapper.addInfoBoardComment(infoBoardComment);
	}
	
	// 게시글 댓글 조회
	public int getCommnetCnt(String infoBoardCode) {
		return infoBoardMapper.getCommentCnt(infoBoardCode);
	}
	
	// 정보 게시판 목록 조회
	public List<InfoBoard> getInfoBoardList(int startIndex, int pageSize){
		List<InfoBoard> infoList = infoBoardMapper.getInfoBoardList(startIndex, pageSize);
		
		for(InfoBoard info: infoList) {
			int commentCnt = infoBoardMapper.getCommentCnt(info.getInfoBoardCode());
			info.setCommentCnt(commentCnt);
		}
		
		return infoList;
	};

	// 게시글 수정
	public int modifyInfoBoard(InfoBoard infoBoard) {
		return infoBoardMapper.modifyInfoBoard(infoBoard);
	}
	
	// 게시글 등록
	public int addInfoBoard(InfoBoard infoBoard) {
		return infoBoardMapper.addInfoBoard(infoBoard);
	};
	
	// 정보 게시글 조회
	public InfoBoard getInfoBoardDetail(String infoBoardCode) {
		return infoBoardMapper.getInfoBoardDetail(infoBoardCode);
	}
	
}
