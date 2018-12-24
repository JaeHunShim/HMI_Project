package hi.proejct.management.board.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.UserInfo;
import hi.proejct.management.user.repository.UserRepository;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRepository.class); 
	@PersistenceContext
	EntityManager em;
	
	public List<Board> boardListAll(HttpSession session) throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setUser_id((String)session.getAttribute("user_id"));
		CriteriaBuilder cb = em.getCriteriaBuilder(); // entitiyManager에서 c
		CriteriaQuery<Board> cq = cb.createQuery(Board.class);
		Root<Board> root = cq.from(Board.class); // from절 생성 
		Predicate companyNameEqual= cb.equal(root.get("user_id"),"jaehuniya");
		logger.info("view List userId" + userInfo.getUser_id());
		Order dateDesc = cb.desc(root.get("regdate")); // 정렬
		cq.select(root)
			.where(companyNameEqual)
			.orderBy(dateDesc);
		
		List<Board> board = em.createQuery(cq).getResultList();
		return board;
		
	}
}
