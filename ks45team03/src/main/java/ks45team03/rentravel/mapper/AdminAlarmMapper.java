package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.AlarmWish;

@Mapper
public interface AdminAlarmMapper {
	
	//관심상품반납 알림
	public List<AlarmWish> adminGetAlarmWishList();

}
