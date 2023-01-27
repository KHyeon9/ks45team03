package ks45team03.rentravel.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team03.rentravel.mapper.MileageMapper;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor

public class MileageService {
	
	private final MileageMapper mileageMapper;
	

}
