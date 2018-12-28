package hi.proejct.management.board.repository;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.Criteria;
import hi.proejct.management.domain.UserInfo;

public interface BoardRepository {

	public List<Board> boardListAll(UserInfo userInfo,Criteria cri) throws Exception;
	
	public Long countPaging(UserInfo userInfo) throws Exception;
	
	public void regigser(Board board) throws Exception;
	
}
