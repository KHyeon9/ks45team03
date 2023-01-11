package ks45team03.rentravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team03.rentravel.dto.FileDto;


@Mapper
public interface FileMapper {
	
	public int addFileGroup(String fileGroupCode, String fileCode);

	public int addFile(List<FileDto> fileList); 
	
	public List<FileDto> getFileList();
	
	public FileDto getFileInfoByIdx(String fileCode);
}
