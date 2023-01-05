package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.InquiryBoard;

@Mapper
public interface InquiryBoardMapper {
	
	/* 1 대 1 문의게시판 답변 게시글 조회 */
	public InquiryBoard getInquiryReBoard(String inquiryReBoardCode);
	
	/* 1 대 1 문의게시판 게시글 상세 조회 */
	public InquiryBoard getInquiryBoard(String inquiryBoardCode);
	
	/*  1 대 1 문의게시판 답글목록 조회 */ 
	public List<InquiryBoard> getInquiryBoardReList ();
	
	/* 1 대 1 문의게시판 목록 조회 */
	public List<InquiryBoard> getInquiryBoardList (int startIndex, int pageSize);
	
	
	/* 1 대 1 문의게시판 목록 행 갯수 */
	public int inquiryBoardListCnt ();
	
}