package hi.proejct.management.user.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import hi.proejct.management.domain.UserInfo;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	@Autowired
	private  BCryptPasswordEncoder passwordEncoder;
	
	@PersistenceContext
	EntityManager em;
	
	//join
	public void register(UserInfo userInfo) throws Exception{
        
		String encPassword = passwordEncoder.encode(userInfo.getPassword());
        
        userInfo.setPassword(encPassword);
		logger.info("암호화 해서 들어가는 번호:" + userInfo.getPassword());
        em.persist(userInfo);
		
    }
	//유무확인
	@Override
	public UserInfo userCheck(UserInfo userInfo) throws Exception {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserInfo> cq = cb.createQuery(UserInfo.class);
		Root<UserInfo> root = cq.from(UserInfo.class);
		
		Predicate p = cb.equal(root.get("user_id"),userInfo.getUser_id());
		Predicate p1= cb.equal(root.get("password"),userInfo.getPassword());
		cq.select(root)
			.where(p,p1);
		
		UserInfo result = em.createQuery(cq).getSingleResult();
		
		logger.info("result 값 정보:" + result);
		
		return result;
	}
	@Override
	public UserInfo findUser(String user_id) throws Exception {
		
		return em.find(UserInfo.class, user_id);
	}
	
}
