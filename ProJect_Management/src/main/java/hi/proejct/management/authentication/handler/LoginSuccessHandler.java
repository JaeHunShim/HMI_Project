package hi.proejct.management.authentication.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.util.UrlUtils;

import hi.proejct.management.domain.UserInfo;
import hi.proejct.management.user.service.UserService;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
	
	private String loginidname;
	private String defaultUrl;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

			try {
				UserInfo userInfo = userService.userFind(request.getParameter("user_id"));
				request.getSession().setAttribute("session", userInfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		clearAuthenticationAttributes(request);
		
		resultRedirectStrategy(request,response,authentication);
		
	}
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION); 
	}
	protected void resultRedirectStrategy(HttpServletRequest request , HttpServletResponse response,
			Authentication authentication) throws IOException,ServletException {
		
		SavedRequest saveRequest = requestCache.getRequest(request, response);
		
		if(saveRequest != null) {
			useSessionUrl(request,response);
			logger.info("권한이 없는 페이지에 접근하게 되면 가게될 페이지=========== ");
		}else {
			logger.info("로그인 url로 이동했을 경우에=============");
			useDefaultUrl(request,response);
		}
	}
	protected void useSessionUrl(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		SavedRequest saveRequest = requestCache.getRequest(request, response);
		String targetUrl = saveRequest.getRedirectUrl();
		redirectStratgy.sendRedirect(request, response, targetUrl);
	}
	protected void useDefaultUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		redirectStratgy.sendRedirect(request, response, defaultUrl);
	}
	
	public String getLoginidname() {
		return loginidname;
	}

	public void setLoginidname(String loginidname) {
		this.loginidname = loginidname;
	}

	public String getDefaultUrl() {
		return defaultUrl;
	}

	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}
}
