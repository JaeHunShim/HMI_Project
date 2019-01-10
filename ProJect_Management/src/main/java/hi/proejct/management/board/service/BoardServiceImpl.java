package hi.proejct.management.board.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hi.proejct.management.board.repository.BoardRepository;
import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.Criteria;
import hi.proejct.management.domain.FileVO;
import hi.proejct.management.domain.PageMaker;
import hi.proejct.management.domain.UserInfo;
import hi.proejct.management.util.FileUtil;

@Service
@Transactional
public class BoardServiceImpl implements BoardSerivce {
	
	private static final Logger logger= LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Resource(name="fileUtil")
	private FileUtil fileUtil;
	
	@Override
	public List<Board> findAll(UserInfo userInfo ,Criteria cri) throws Exception {
		
		return boardRepository.boardListAll(userInfo,cri);
	}

	@Override
	public Long countList(UserInfo userInfo) throws Exception {
		
		return boardRepository.countPaging(userInfo);
	}

	@Override
	public void register(UserInfo userInfo, Board board, MultipartHttpServletRequest request,FileVO fileVO) throws Exception {
		
		boardRepository.register(userInfo, board);
		
		boardRepository.fileInsert(request, fileVO,board);
		
	}

	@Override
	public FileVO detailView(Board board) throws Exception {
		
		return boardRepository.detailView(board);
	}

	@Override
	public FileVO selectFileInfo(FileVO fileVO) throws Exception {
		
		return boardRepository.selectFileInfo(fileVO);
	}

	@Override
	public void delete(Board board) throws Exception {
		
		boardRepository.boardDelete(board);
	}

	@Override
	public void update(Board board, FileVO fileVO) throws Exception {
		
		boardRepository.updateDetailView(board, fileVO);
	}

}
