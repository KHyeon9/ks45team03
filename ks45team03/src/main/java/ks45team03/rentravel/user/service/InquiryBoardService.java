package ks45team03.rentravel.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.InquiryBoard;
import ks45team03.rentravel.mapper.InquiryBoardMapper;

@Service
@Transactional
public class InquiryBoardService {

	private final InquiryBoardMapper inquiryBoardMapper;
	
	public InquiryBoardService (InquiryBoardMapper inquiryBoardMapper) {
		this.inquiryBoardMapper = inquiryBoardMapper;
	}
	
	
	/* 1 대 1 문의 게시글 삭제 */
	public int removeInquiryBoard (String inquiryBoardCode) {
		
		return inquiryBoardMapper.removeInquiryBoard(inquiryBoardCode);
	}
	
	
	/* 1 대 1 문의 게시글 수정 */
	public int modifyInquiryBoard (InquiryBoard inquiryBoard) {
		
		return inquiryBoardMapper.modifyInquiryBoard(inquiryBoard);
	}
	
	
	/* 1 대 1 문의 게시글 추가 */
	public int addInquiryBoard (InquiryBoard inquiryBoard) {
		
		return inquiryBoardMapper.addInquiryBoard(inquiryBoard);
	}
}
