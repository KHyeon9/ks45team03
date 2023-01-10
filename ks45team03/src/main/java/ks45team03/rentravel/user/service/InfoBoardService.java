package ks45team03.rentravel.user.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext.AND;
import ks45team03.rentravel.dto.FileDto;
import ks45team03.rentravel.dto.InfoBoard;
import ks45team03.rentravel.dto.InfoBoardComment;
import ks45team03.rentravel.mapper.CommonNewCode;
import ks45team03.rentravel.mapper.InfoBoardMapper;

@Service
@Transactional
public class InfoBoardService{
	// 의존성 주입
	private final InfoBoardMapper infoBoardMapper;
	private final FileService fileService;
	private final CommonNewCode commonNewCode;
	
	public InfoBoardService(InfoBoardMapper infoBoardMapper, FileService fileService, CommonNewCode commonNewCode) {
		this.infoBoardMapper = infoBoardMapper;
		this.fileService = fileService;
		this.commonNewCode = commonNewCode;
	}
	
	// 조회수 증가 처리
	public int viewIncrease(String infoBoardCode) {
		return infoBoardMapper.viewIncrease(infoBoardCode);
	}
	
	// 게시글 댓글 수정
	public int modifyInfoBoardComment(InfoBoardComment infoBoardComment) {
		return infoBoardMapper.modifyInfoBoardComment(infoBoardComment);
	}
	
	// 게시글 댓글 삭제
	public int removeInfoBoardComment(String infoBoardCommentCode) {
		return infoBoardMapper.removeInfoBoardComment(infoBoardCommentCode);
	}
	
	// 게시글 댓글 등록
	public int  addInfoBoardComment(InfoBoardComment infoBoardComment) {
		return infoBoardMapper.addInfoBoardComment(infoBoardComment);
	}
	
	// 게시글 댓글 조회
	public int getCommnetCnt(String infoBoardCode) {
		return infoBoardMapper.getCommentCnt(infoBoardCode);
	}
	
	// 정보 게시판 목록 조회
	public List<InfoBoard> getInfoBoardList(int startIndex, int pageSize){
		List<InfoBoard> infoList = infoBoardMapper.getInfoBoardList(startIndex, pageSize);
		
		for(InfoBoard info: infoList) {
			int commentCnt = infoBoardMapper.getCommentCnt(info.getInfoBoardCode());
			info.setCommentCnt(commentCnt);
		}
		
		return infoList;
	};

	// 게시글 수정
	public int modifyInfoBoard(InfoBoard infoBoard) {
		return infoBoardMapper.modifyInfoBoard(infoBoard);
	}
	
	// 게시글 등록
	public int addInfoBoard(InfoBoard infoBoard, MultipartFile[] uploadfile, String fileRealPath) {
		List<FileDto> fileList =  fileService.fileUpload(uploadfile, fileRealPath);
		String fileGroupCode = commonNewCode.getCommonNewCode("tb_file_group", "file_group_code");
		
		if (fileList != null) {
			for(FileDto fileInfo : fileList) {
				String fileCode =  fileInfo.getFileCode();
				fileService.addFileGroup(fileGroupCode, fileCode);
			}
		}
		
		infoBoard.setFileGroupCode(fileGroupCode);
		infoBoardMapper.addInfoBoard(infoBoard);
				
		return 0;
	};
	
	// 정보 게시글 조회
	public InfoBoard getInfoBoardDetail(String infoBoardCode) {
		return infoBoardMapper.getInfoBoardDetail(infoBoardCode);
	}
	
}
