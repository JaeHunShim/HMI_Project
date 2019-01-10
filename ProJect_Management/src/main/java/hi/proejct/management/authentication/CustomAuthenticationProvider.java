package hi.proejct.management.authentication;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import hi.proejct.management.domain.CustomUserDetails;
import hi.proejct.management.user.service.UserService;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		logger.info("AuthenticationProvider start==========================");
		logger.info("provider에서 받아오는 정보:" + customUserDetailsService.loadUserByUsername(username));
		/*CustomUserDetails user = (CustomUserDetails)customUserDetailsService.loadUserByUsername(username);*/
		
		UserDetails user = customUserDetailsService.loadUserByUsername(username);
		
		if(!user.isEnabled() || !user.isCredentialsNonExpired()) {
			throw new AuthenticationCredentialsNotFoundException(username);
		}
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();
		
		logger.info("AuthenticationProvider loadUserByUserName =============== 3");
		
		if(!matchPassword(password,user.getPassword())) {
			logger.debug("matchPassword ========================== flase");
			throw new BadCredentialsException(username);
		}
		logger.info("mathPassword ========================true");
		
		return new UsernamePasswordAuthenticationToken(username,password,authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	private boolean matchPassword(String loginPassword,String password) {
		logger.debug("matchPassword ============================");
		
		return loginPassword.equals(password);
	}

}
