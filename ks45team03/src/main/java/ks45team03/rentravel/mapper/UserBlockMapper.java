package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.Block;

@Mapper
public interface UserBlockMapper {
	
	/* 차단한 회원 id 조회 */
	public List<Block> getUserBlockId (String loginId);

	/* 차단 ID 삭제 */
	public int removeUserBlock (String blockedUserId);
	
	/* 차단 ID 추가 */
	public int addUserBlock (String userId, String loginId);
	
	/* 차단목록 조회 */
	public List<Block> getUserBlockList(String loginId);
}
