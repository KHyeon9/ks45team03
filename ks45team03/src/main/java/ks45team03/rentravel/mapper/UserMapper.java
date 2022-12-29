package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.RegionSgg;
import ks45team03.rentravel.dto.RegionSido;

@Mapper
public interface UserMapper {

	public List<RegionSido> regionSidoList();
	
}
