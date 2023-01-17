package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.NoticeBoard;

@Mapper
public interface AdminNoticeBoardMapper {
	
	public int noticeBoardListCnt(String searchKey, String searchValue);

	// 공지사항 리스트
	public List<NoticeBoard> adminNoticeBoardList(int startIndex, int pageSize, String searchKey, String searchValue);
	
	// 공지사항 상세보기
	public NoticeBoard adminDetailNoticeBoard(String noticeBoardCode);
	
	// 공지사항 등록
	public int adminAddNoticeBoard(NoticeBoard noticeBoard);
	
	// 공지사항 수정화면
	public NoticeBoard modifyNoticeBoard(String noticeBoardCode);
	
	// 공지사항 수정처리
	public int modifyNoticeBoardAction(NoticeBoard noticeBoard);
	
	// 공지사항 삭제
	public int removeNoticeBoard(String noticeBoardCode);

}
