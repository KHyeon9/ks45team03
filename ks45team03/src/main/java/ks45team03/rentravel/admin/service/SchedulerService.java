package ks45team03.rentravel.admin.service;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ks45team03.rentravel.dto.LoginHistory;
import ks45team03.rentravel.mapper.AdminUserMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SchedulerService {
	
	private final AdminUserMapper adminUserMapper;

	@Scheduled(cron = "0 0 0 * * *")  // 매일 24시에 실행
	public void run() {
		
		// 휴면계정 테이블에서 존재하는 아이디를 조회해 추출
		// 로그인 이력에서 최종 로그인 날짜가 현재 날자와 비교해 180일 이상인 회원아이디와 로그인하지 않은 날짜 추출
		List<LoginHistory> getSleeperAccountByLoginHistory = adminUserMapper.getSleeperAccountByLoginHistory();
		adminUserMapper.addSleeperAccount(getSleeperAccountByLoginHistory);
		
		}
	}
