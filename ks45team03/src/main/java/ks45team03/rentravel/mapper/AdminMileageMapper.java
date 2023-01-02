package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.MileageSaveUse;



@Mapper
public interface AdminMileageMapper {

	//모든 적립금 조회
	public List<MileageSaveUse> adminGetMileageList();
	


}