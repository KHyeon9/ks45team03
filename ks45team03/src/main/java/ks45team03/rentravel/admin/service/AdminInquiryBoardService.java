package ks45team03.rentravel.admin.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.InquiryBoard;
import ks45team03.rentravel.mapper.InquiryBoardMapper;

@Transactional
@Service
public class AdminInquiryBoardService {

	
private final InquiryBoardMapper inquiryBoardMapper;
	
	public AdminInquiryBoardService (InquiryBoardMapper inquiryBoardMapper) {
		this.inquiryBoardMapper = inquiryBoardMapper;
	}
	
	/* 1 대 1 문의 게시글 답글 추가 */
	public int adminAddInquiryBoard (InquiryBoard inquiryBoard) {
		
		return	inquiryBoardMapper.adminAddInquiryBoard(inquiryBoard);
		
	}
}
