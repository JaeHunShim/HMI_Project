package hi.proejct.management.user.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import hi.proejct.management.domain.UserInfo;
import hi.proejct.management.user.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/user/signin", method=RequestMethod.GET)
	public String usersignInGet() {
		
		return "user/signin";
	}
	@RequestMapping(value="/user/signin", method=RequestMethod.POST)
	public String usersignInPost(UserInfo userInfo,Model model) throws Exception {
		
		UserInfo user = userService.userCheck(userInfo);
		model.addAttribute("userInfo",user);
		logger.info("로그인 회원정보:" + user);
		
		return "board/viewList";
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
