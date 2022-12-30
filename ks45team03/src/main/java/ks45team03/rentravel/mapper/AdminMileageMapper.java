package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.MileagePaymentSave;
import ks45team03.rentravel.dto.MileageRentalCancelSave;

@Mapper
public interface AdminMileageMapper {

	//결제적립금 조회
	public List<MileagePaymentSave> adminGetMileagePaymentSaveList();
	
	//취소적립금 조회
	public List<MileageRentalCancelSave> adminGetMileageRentalCancelSaveList();



}