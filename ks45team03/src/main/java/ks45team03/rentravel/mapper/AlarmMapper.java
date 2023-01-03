package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.AlarmWish;

@Mapper
public interface AlarmMapper {
	
	public List<AlarmWish> getAlarmWishList();
}
