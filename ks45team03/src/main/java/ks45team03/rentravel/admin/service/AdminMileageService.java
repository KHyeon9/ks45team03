package ks45team03.rentravel.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.dto.MileagePaymentSave;
import ks45team03.rentravel.dto.MileageRentalCancelSave;
import ks45team03.rentravel.dto.MileageSaveUse;
import ks45team03.rentravel.mapper.AdminMileageMapper;

@Service
@Transactional
public class AdminMileageService {

	private final AdminMileageMapper adminMileageMapper;

	public AdminMileageService(AdminMileageMapper adminMileageMapper) {
		this.adminMileageMapper = adminMileageMapper;
	}

	/**
	 * 회원의 적립금 내역 조회
	 * @param searchValue 
	 * @param searchKey 
	 * @return
	 */
	public List<MileageSaveUse> adminGetMileageList(String searchKey, String searchValue){
		
		List<MileageSaveUse> mileageList = adminMileageMapper.adminGetMileageList(searchKey, searchValue);
		
		return mileageList;
	}
	
	
}