package hi.proejct.management.authentication;




import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hi.proejct.management.domain.CustomUserDetails;
import hi.proejct.management.domain.UserInfo;
import hi.proejct.management.user.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("loadUserByUsername strat------------------");
			UserInfo user = null;
		try {
			user = userRepository.findUser(username);
			logger.info("CustomUserDetialsService 의 userInfo정보  = "  + user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user == null) {
			logger.debug("no user =============== AthenticatioinProvider");
			throw new InternalAuthenticationServiceException(username);
		}
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getAuth());
		UserDetails userDetails = new User(user.getUser_id(),user.getPassword(),Arrays.asList(authority));
		logger.debug("UserDetailService ========================== return success!!!");
		
		return userDetails;
	}

}
