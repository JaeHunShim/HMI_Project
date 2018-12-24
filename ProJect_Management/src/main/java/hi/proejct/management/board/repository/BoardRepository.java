package hi.proejct.management.board.repository;

import java.util.List;

import javax.servlet.http.HttpSession;

import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.UserInfo;

public interface BoardRepository {

	public List<Board> boardListAll(HttpSession session) throws Exception;
}
