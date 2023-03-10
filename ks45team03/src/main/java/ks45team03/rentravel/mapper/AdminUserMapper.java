package ks45team03.rentravel.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.LoginHistory;
import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.dto.RemoveAccount;
import ks45team03.rentravel.dto.SleeperAccount;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.dto.UserLevel;

@Mapper
public interface AdminUserMapper {
		// 회원 목록
		public List<User> userList();
		
		// 테이블 행의 갯수
		public int getUserListCnt(String searchKey, String searchValue);
		
		// 수정처리
		public int modifyUser(User user);
		
		// 특정 회원 조회(수정)
		public User getUserInfoById(String userId);		
		
		// 회원 등급 조회
		public List<UserLevel> getUserLevelList();
		
		// 로그인 이력 조회
		public List<LoginHistory> loginHistory(int startIndex, int pageSize, String searchValue);
		// 로그인 이력 행갯수
		public int loginHistoryCnt(String searchValue);
		
		// 로그인 이력을 통한 휴면 계정 조회
		public List<LoginHistory> getSleeperAccountByLoginHistory();
		
		// 휴면 계정 DB등록
		public void addSleeperAccount(List<LoginHistory> getSleeperAccountByLoginHistory);
		
		// 휴면 계정 조회
		public List<SleeperAccount> sleeperAccountList(int startIndex, int pageSize, String searchValue);
		
		// 휴면 계정 행갯수
		public int sleeperAccountCnt(String searchValue);
		
		// 탈퇴 계정 조회
		public List<RemoveAccount> removeAccountList();
		
		// 탈퇴 계정 행갯수
		public int removeAccountCnt();
		
		// 회원 삭제
		public int removeUserByAdmin(String userId);
		
		// 회원 삭제시 탈퇴회원목록으로 
		public void setRemoveAccount(String userId);
		
		// 회원 수정 시/도 
		public List<RegionSido> regionSidoList(String regionSggCode);
		
}
