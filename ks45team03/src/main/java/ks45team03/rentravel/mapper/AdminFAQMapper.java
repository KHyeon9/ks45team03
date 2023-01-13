package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.FAQ;
import ks45team03.rentravel.dto.FAQCategory;

@Mapper
public interface AdminFAQMapper {
	
	public List<FAQ> adminFAQList(int startIndex, int pageSize, String searchKey, String searchValue);
	
	public int faqListCnt(String searchKey, String searchValue);
	
	public FAQ adminDetailFAQ(String faqBoardCode);
	
	public int adminRemoveFAQ(String faqBoardCode);
	
	public List<FAQCategory> FAQCategoryList();
	
	public int adminAddFAQ(FAQ faq);
	
	public FAQ modifyFAQ(String faqBoardCode);
	
	public int adminModifyFAQ(FAQ faq);
}
