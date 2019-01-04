package hi.proejct.management.board.repository;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.Criteria;
import hi.proejct.management.domain.FileVO;
import hi.proejct.management.domain.UserInfo;

public interface BoardRepository {

	public List<Board> boardListAll(UserInfo userInfo,Criteria cri) throws Exception;
	
	public Long countPaging(UserInfo userInfo) throws Exception;
	
	public void register(UserInfo userInfo, Board board) throws Exception;
	
	public Board detailView(Board board) throws Exception;
	
	public void fileInsert(MultipartHttpServletRequest request,FileVO fileVO,Board board) throws Exception;
	
	
}
