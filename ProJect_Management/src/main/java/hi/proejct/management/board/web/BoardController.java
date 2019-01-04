package hi.proejct.management.board.web;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hi.proejct.management.board.service.BoardSerivce;
import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.Criteria;
import hi.proejct.management.domain.FileVO;
import hi.proejct.management.domain.PageMaker;
import hi.proejct.management.domain.UserInfo;



@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
 	private BoardSerivce boardService;
	
	@RequestMapping(value="/viewList", method=RequestMethod.GET)
	public String BoardListAll(HttpSession session ,Model model,Criteria cri) throws Exception{
		UserInfo userInfo = (UserInfo)session.getAttribute("session");
		model.addAttribute("board",boardService.findAll(userInfo,cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.countList(userInfo));
		model.addAttribute("pageMaker",pageMaker);
		return "board/viewList";
	}
	@RequestMapping(value="/regster", method=RequestMethod.GET)
	public String regsterGet() throws Exception{

		return "board/regster";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String regsterPost(UserInfo userInfo ,Board board,FileVO fileVO,MultipartHttpServletRequest request ) throws Exception {

		boardService.register(userInfo, board, request,fileVO);
		
		return "redirect:/board/viewList";
	}
	@RequestMapping(value="/detailView",method=RequestMethod.GET)
	public String detailView(Board board, Model model) throws Exception {
		
		model.addAttribute("board", boardService.detailView(board));
		
		return "board/detailView";
	}
}
