package hi.proejct.management.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.Criteria;
import hi.proejct.management.domain.UserInfo;

public interface BoardSerivce {
	
	public List<Board> findAll(UserInfo userInfo, Criteria cri) throws Exception;
	
	public Long countList(UserInfo userInfo) throws Exception;
	
	public void regist(Board board) throws Exception;
}
