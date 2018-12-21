package hi.proejct.management.user.service;

import hi.proejct.management.domain.UserInfo;

public interface UserService {

	public void signUp(UserInfo userInfo) throws Exception;
	
	public UserInfo userCheck(UserInfo userInfo) throws Exception;
}
