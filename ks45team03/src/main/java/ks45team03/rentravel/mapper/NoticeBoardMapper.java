package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.NoticeBoard;

@Mapper
public interface NoticeBoardMapper {
	
	// 공지사항 상세보기
	public NoticeBoard detailNoticeBoard(String noticeBoardCode);
	
	// 공지사항 조회
	public List<NoticeBoard> noticeBoardList(int startIndex, int pageSize);
	
	// 테이블 행 갯수
	public int noticeBoardListCnt();
}
