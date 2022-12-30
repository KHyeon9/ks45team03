package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.MileagePaymentSave;
import ks45team03.rentravel.dto.MileageRentalCancelSave;
import ks45team03.rentravel.mapper.AdminMileageMapper;

@Service
@Transactional
public class AdminMileageService {

	private final AdminMileageMapper adminMileageMapper;

	public AdminMileageService(AdminMileageMapper adminMileageMapper) {
		this.adminMileageMapper = adminMileageMapper;
	}

	public List<MileagePaymentSave> adminGetMileagePaymentSaveList(){
		List<MileagePaymentSave> mileagePaymentSaveList = adminMileageMapper.adminGetMileagePaymentSaveList();

		return mileagePaymentSaveList;
	}
	
	public List<MileageRentalCancelSave> adminGetMileageRentalCancelSaveList(){
		List<MileageRentalCancelSave> mileageRentalCancelSave = adminMileageMapper.adminGetMileageRentalCancelSaveList();
		
		return mileageRentalCancelSave;
	}
}