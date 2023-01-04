package ks45team03.rentravel.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.mapper.InquiryBoardMapper;

@Service
@Transactional
public class InquiryBoardService {

	private final InquiryBoardMapper inquiryBoardMapper;
	
	public InquiryBoardService (InquiryBoardMapper inquiryBoardMapper) {
		this.inquiryBoardMapper = inquiryBoardMapper;
	}
	
	
	
}
