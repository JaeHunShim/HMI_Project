package hi.proejct.management.authentication.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import hi.proejct.management.user.service.UserService;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	@Autowired
	private UserService userService;
	
	private String loginidname;
	private String loginpwname;
	private String errormsgname;
	private String defaultFailureUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		

	}
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public String getLoginidname() {
		return loginidname;
	}


	public void setLoginidname(String loginidname) {
		this.loginidname = loginidname;
	}


	public String getLoginpwname() {
		return loginpwname;
	}


	public void setLoginpwname(String loginpwname) {
		this.loginpwname = loginpwname;
	}


	public String getErrormsgname() {
		return errormsgname;
	}


	public void setErrormsgname(String errormsgname) {
		this.errormsgname = errormsgname;
	}


	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}


	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}


}
