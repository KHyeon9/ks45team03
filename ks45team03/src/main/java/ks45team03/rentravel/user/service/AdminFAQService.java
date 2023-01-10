package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.FAQ;
import ks45team03.rentravel.mapper.AdminFAQMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminFAQService {
	
	private final AdminFAQMapper adminFAQMapper;
	
	public List<FAQ> adminFAQList(int startIndex, int pageSize, String searchKey, String searchValue){
		
		List<FAQ> adminFAQList = adminFAQMapper.adminFAQList(startIndex, pageSize, searchKey, searchValue);
		
		return adminFAQList;
	}
	
	public FAQ adminDetailFAQ(String faqBoardCode) {
	
		FAQ adminDetailFAQ = adminFAQMapper.adminDetailFAQ(faqBoardCode);
		
		return adminDetailFAQ;
	}
	
	public void adminRemoveFAQ(String faqBoardCode) {
		adminFAQMapper.adminRemoveFAQ(faqBoardCode);
	}
}
