package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.FAQ;

@Mapper
public interface FAQMapper {

	public List<FAQ> FAQList();
	
	public FAQ FAQDetail(String faqBoardCode);
}
