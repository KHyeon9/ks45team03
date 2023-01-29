package ks45team03.rentravel.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.LoginHistory;
import ks45team03.rentravel.dto.RegionSgg;
import ks45team03.rentravel.dto.RegionSido;
import ks45team03.rentravel.dto.SleeperAccount;
import ks45team03.rentravel.dto.User;
import ks45team03.rentravel.dto.UserEvaluation;
import ks45team03.rentravel.dto.UserEvaluationType;

@Mapper
public interface UserMapper {
	
	public int ModifyuserInfo(User user);
	// 비밀번호 일치
	public User checkPwByUserId(String userId);
	
	public User userInfo(String loginId);
	
	public int addUser(User user);
	
	public List<RegionSido> getRegionSido();
	
	public List<RegionSido> getMyPageRegionSido(String regionSidoCode);
	
	public List<RegionSgg> selectRegionSgg(String project);
	
	public boolean checkUserId(String userId);
	
	public boolean checkUserNickName(String userNickName);
	
	public void loginHistory(String loginId);
	
	public int findIdCheck(String userName, String userEmail, String userPhoneNumber);
	
	public List<User> showFindId(String userName, String userEmail, String userPhoneNumber);
	
	public List<UserEvaluation> userEvaluation(String userNickName);
	
	public List<UserEvaluationType> userEvaluationList();
	
	public int addUserEvaluation(String userNickName, List<String> userEvaluationTypeCodeList, String loginId);
	
	public int getDuplicateEvaluation(String userNickName, String loginId);
	
	public List<UserEvaluation> getUserEvaluationDoneList(String userNickName, String loginId);
	
	public int deleteUserEvaluation(String userNickName, String loginId);
	
	public int checkSleeperId(String userId);
	
	public int checkRemoveId(String userId);
	
	public SleeperAccount getSleeperAccount(String userId);
	
	public int removeUser(String loginId);
	
	public void setRemoveAccount(String loginId);
	
}
