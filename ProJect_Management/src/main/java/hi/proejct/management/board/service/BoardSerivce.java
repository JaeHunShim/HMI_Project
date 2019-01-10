package hi.proejct.management.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.Criteria;
import hi.proejct.management.domain.FileVO;
import hi.proejct.management.domain.UserInfo;

public interface BoardSerivce {
	
	public List<Board> findAll(UserInfo userInfo, Criteria cri) throws Exception;
	
	public Long countList(UserInfo userInfo) throws Exception;
	
 	public void register(UserInfo userInfo, Board board,MultipartHttpServletRequest request,FileVO fileVO) throws Exception;
	
	public FileVO detailView(Board board) throws Exception;
	
	public FileVO selectFileInfo(FileVO fileVO) throws Exception;
	
	public void delete(Board board) throws Exception;
	
	public void update(Board board, FileVO fileVO) throws Exception;
	
}
