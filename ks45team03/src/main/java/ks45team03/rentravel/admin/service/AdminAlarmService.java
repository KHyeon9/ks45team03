package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.AlarmWish;
import ks45team03.rentravel.mapper.AdminAlarmMapper;

@Service
@Transactional
public class AdminAlarmService {

	private final AdminAlarmMapper adminAlarmMapper;
	
	public AdminAlarmService(AdminAlarmMapper adminAlarmMapper) {
		this.adminAlarmMapper = adminAlarmMapper;
	}
	
	public List<AlarmWish> adminGetAlarmWishList(){
		List<AlarmWish> alarmWishList = adminAlarmMapper.adminGetAlarmWishList();
		
		
		return alarmWishList;
	}
}
