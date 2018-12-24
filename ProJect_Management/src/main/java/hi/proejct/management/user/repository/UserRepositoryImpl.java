package hi.proejct.management.user.repository;

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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import hi.proejct.management.domain.UserInfo;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private static final Logger logger = LoggerFactory.getLogger(UserRepository.class); 
	@PersistenceContext
	EntityManager em;
	
	//join
	public void register(UserInfo userInfo) throws Exception{
        
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
		cq.select(root).where(p,p1);
		
		TypedQuery<UserInfo> query = em.createQuery(cq);
		
		UserInfo result = query.getSingleResult();
		logger.info("user정보:" + result);
		
		return result;
	}
	

}
