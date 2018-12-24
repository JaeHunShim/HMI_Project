package hi.proejct.management.board.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hi.proejct.management.board.service.BoardSerivce;
import hi.proejct.management.domain.UserInfo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
 	private BoardSerivce boardService;
	
	@RequestMapping(value="/viewList", method=RequestMethod.GET)
	public String BoardListAll(Model model , HttpSession session) throws Exception{
		
		model.addAttribute("board", boardService.findAll(session));
		
		return "board/viewList";
	}
}
