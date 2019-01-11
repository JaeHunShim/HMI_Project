package hi.proejct.management.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String main() {
		
		return "user/signin";
	}
	@RequestMapping("/main/index")
	public String index() {
		
		return "main/index";
	}
	@RequestMapping(value="/access_denied")
	public ModelAndView accessDenied() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "접근권한이 없습니다.");
		mav.addObject("url","/");
		
		return mav;
	}
	@RequestMapping(value="/access_denied_page")
	public String accessDeniedPage() throws Exception {
		return "access_denied_page";
	}
}
