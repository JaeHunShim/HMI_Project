package hi.proejct.management.user.repository;

import java.util.List;

import hi.proejct.management.domain.UserInfo;

public interface UserRepository {
	
	public void register(UserInfo userInfo) throws Exception;
	
	public UserInfo userCheck(UserInfo userInfo) throws Exception;
	
	public UserInfo findUser(String user_id) throws Exception;
	
}
