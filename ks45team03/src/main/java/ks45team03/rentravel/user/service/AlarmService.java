package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.AlarmWish;
import ks45team03.rentravel.mapper.AlarmMapper;

@Service
@Transactional
public class AlarmService {
	
	private final AlarmMapper alarmMapper;
	
	public AlarmService(AlarmMapper alarmMapper) {
		this.alarmMapper = alarmMapper;
	}
	
	/**
	 *
	 * @return
	 */
	public List<AlarmWish> getAlarmWishList(){
		List<AlarmWish> alarmWishList = alarmMapper.getAlarmWishList();
		
		return alarmWishList;
	}
}