package hi.proejct.management.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import hi.proejct.management.domain.UserInfo;
import hi.proejct.management.user.repository.UserRepository;


@Service
@Transactional
public class UserServiceImple implements UserService {
	
	@Autowired
	UserRepository userInfoRepository;
	
	@Override
	public void signUp(UserInfo userInfo) throws Exception {
		
		userInfoRepository.register(userInfo);
	}

	@Override
	public UserInfo userCheck(UserInfo userInfo) throws Exception {
		
		UserInfo result = userInfoRepository.userCheck(userInfo);
		
		if(result == null) {
			return null;
		}else {
			return result;
		}
	}

}
