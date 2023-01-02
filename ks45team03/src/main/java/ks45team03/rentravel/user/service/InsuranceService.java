package ks45team03.rentravel.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team03.rentravel.mapper.InsuranceMapper;


@Service
public class InsuranceService {
	
	private final InsuranceMapper insuranceMapper;
	
	public InsuranceService(InsuranceMapper insuranceMapper) {
		this.insuranceMapper = insuranceMapper;
	}
	
	
}
