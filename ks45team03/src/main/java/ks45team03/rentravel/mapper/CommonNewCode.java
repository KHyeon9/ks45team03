package ks45team03.rentravel.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonNewCode {
	// 코드 생성 모듈
	public String getCommonNewCode(String tableName, String columName);
	
}
