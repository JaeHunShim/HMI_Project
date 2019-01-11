package hi.proejct.management.authentication.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import hi.proejct.management.message.MessageUtils;
import hi.proejct.management.user.service.UserService;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	private static final Logger logger = LoggerFactory.getLogger(LoginFailureHandler.class);
	
	private String loginidname;
	private String loginpwname;
	private String errormsgname;
	private String defaultFailureUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String username = request.getParameter(loginidname);
		String password = request.getParameter(loginpwname);
		String errormsg = exception.getMessage();
		
		//에러들에대한 메시지 처리 
		if(exception instanceof BadCredentialsException) {
            errormsg = MessageUtils.getMessage("error.BadCredentials");
        } else if(exception instanceof InternalAuthenticationServiceException) {
            errormsg = MessageUtils.getMessage("error.BadCredentials");
        } else if(exception instanceof DisabledException) {
            errormsg = MessageUtils.getMessage("error.Disaled");
        } else if(exception instanceof CredentialsExpiredException) {
            errormsg = MessageUtils.getMessage("error.CredentialsExpired");
        }
		//유저 아이디 패스워드 에러메세지 요청 
		request.setAttribute(loginidname, username);
		request.setAttribute(loginpwname, password);
		request.setAttribute(errormsgname, errormsg);
		logger.info("request에서 보내주는 에러 메세지 " + request.getParameter(errormsgname));
		// 로그인 실패시에 입력한 로그인 정보 띄우기 
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);

	}
	protected void loginFailureCount(String username) {
		
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
