package hi.proejct.management.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
