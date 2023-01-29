package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.MileagePaymentSave;
import ks45team03.rentravel.dto.MileageSaveUse;
import ks45team03.rentravel.dto.MileageUse;
import ks45team03.rentravel.dto.User;

@Mapper
public interface MileageMapper {

	
	// 유저 마일리지 적립
	public int addMileageUse(MileageUse mileageUse);
	
	// 유저 결제 마일리지 적립
	public int addMileagePaymentSave(MileagePaymentSave mileagePaymentSave);
	
	// 유저 마일리지 이력 추가
	public int addMileageSaveUse(MileageSaveUse mileageSaveUse);
	
	// 유저 총 마일리지 갱신
	public int modifyUserTotalMileage(User user);
	
}
