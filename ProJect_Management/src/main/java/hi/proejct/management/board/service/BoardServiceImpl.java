package hi.proejct.management.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hi.proejct.management.board.repository.BoardRepository;
import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.UserInfo;

@Service
public class BoardServiceImpl implements BoardSerivce {
	
	private static final Logger logger= LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public List<Board> findAll(HttpSession session) throws Exception {
		
		return boardRepository.boardListAll(session);
	}
}
