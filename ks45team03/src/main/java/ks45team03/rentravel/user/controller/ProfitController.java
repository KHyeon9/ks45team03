package ks45team03.rentravel.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks45team03.rentravel.mapper.UserProfitMapper;
import ks45team03.rentravel.user.service.ProfitService;

@Controller
@RequestMapping("/profit")
public class ProfitController {

	private final ProfitService profitService;
	private final UserProfitMapper userProfitMapper;
	
	public ProfitController (ProfitService profitService,UserProfitMapper userProfitMapper) {
		
		this.profitService = profitService;
		this.userProfitMapper = userProfitMapper;
	}
	
	@PostMapping("/updateProfitList")
	public String updateProfitList () {
		
		
		
		return null;
	}
}
