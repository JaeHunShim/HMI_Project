package hi.proejct.management.user.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import hi.proejct.management.board.service.BoardSerivce;
import hi.proejct.management.domain.UserInfo;
import hi.proejct.management.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BoardSerivce boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/user/signin", method=RequestMethod.GET)
	public String usersignInGet() {
		
		return "user/signin";
	}
	@RequestMapping(value="/user/signin", method=RequestMethod.POST)
	public String usersignInPost(/*UserInfo userInfo,Model model,HttpSession session*/) throws Exception {
		
		/*model.addAttribute("userInfo", userService.userCheck(userInfo));
		session.setAttribute("session", userService.userCheck(userInfo));*/
		
		//return "redirect:/board/viewList";
		
		return "index";
	}
	@RequestMapping(value="/user/signup", method=RequestMethod.GET)
	public String usersignUpGet(UserInfo userInfo) throws Exception {
		
		return "user/signup";
	}
	@RequestMapping(value="/user/signup", method=RequestMethod.POST)
	public String userSignUpPost(UserInfo userInfo) throws Exception {
		
		userService.signUp(userInfo);
		
		return "user/signin";
	}
}
