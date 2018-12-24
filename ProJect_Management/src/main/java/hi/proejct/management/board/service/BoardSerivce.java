package hi.proejct.management.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.UserInfo;

public interface BoardSerivce {
	
	public List<Board> findAll(HttpSession session) throws Exception; 
}
