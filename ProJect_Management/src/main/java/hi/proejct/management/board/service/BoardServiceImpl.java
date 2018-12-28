package hi.proejct.management.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hi.proejct.management.board.repository.BoardRepository;
import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.Criteria;
import hi.proejct.management.domain.PageMaker;
import hi.proejct.management.domain.UserInfo;

@Service
@Transactional
public class BoardServiceImpl implements BoardSerivce {
	
	private static final Logger logger= LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public List<Board> findAll(UserInfo userInfo ,Criteria cri) throws Exception {
		
		return boardRepository.boardListAll(userInfo,cri);
	}

	@Override
	public Long countList(UserInfo userInfo) throws Exception {
		
		return boardRepository.countPaging(userInfo);
	}

	@Override
	public void regist(Board board) throws Exception {
		
		boardRepository.regigser(board);
		
	}
}
