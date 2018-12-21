package hi.proejct.management.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class boardController {
	
	@RequestMapping(value="/viewList",method=RequestMethod.GET)
	public String viewListGet() {
		
		return "board/viewList";
	}
}
