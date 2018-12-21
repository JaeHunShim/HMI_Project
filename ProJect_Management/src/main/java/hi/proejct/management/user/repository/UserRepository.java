package hi.proejct.management.user.repository;

import hi.proejct.management.domain.UserInfo;

public interface UserRepository {
	
	public void register(UserInfo userInfo) throws Exception;
	
	public UserInfo userCheck(UserInfo userInfo) throws Exception;
}
