package hi.proejct.management.board.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.Criteria;
import hi.proejct.management.domain.UserInfo;
import hi.proejct.management.user.repository.UserRepository;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRepository.class); 
	@PersistenceContext
	EntityManager em;
	
	public List<Board> boardListAll(UserInfo userInfo,Criteria cri) throws Exception {
		
		
		CriteriaBuilder cb = em.getCriteriaBuilder(); // entitiyManager에서 CirteriaBuilder 인스터스 생성
		CriteriaQuery<Board> cq = cb.createQuery(Board.class);
		Root<Board> root = cq.from(Board.class); // from절 생성
		Join<Board,UserInfo> t = root.join("userInfo",JoinType.INNER);
		/*Predicate userIdEquels = cb.equal(root.get), userInfo.getUser_id());*/
		Order pnoDesc = cb.desc(root.get("pno")); // 정렬
		cq.select(root)
		/*.where(userIdEquels)*/
		.where(cb.equal(t.get("user_id"), userInfo.getUser_id()))
		.orderBy(pnoDesc);
			
		List<Board> board = em.createQuery(cq).setFirstResult(cri.getPageStart()).
					setMaxResults(cri.getPerPageNum()).getResultList();
		return board;
		
	}
	public Long countPaging(UserInfo userInfo) throws Exception {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Board> root = cq.from(Board.class);
		Join<Board,UserInfo> t = root.join("userInfo",JoinType.INNER);
		cq.select(cb.countDistinct(root));
		cq.where(cb.equal(t.get("user_id"), userInfo.getUser_id()));
		long count =em.createQuery(cq).getSingleResult().intValue();
		return count; 
		
	}
	@Override
	public void regigser(Board board) throws Exception {
		
		em.persist(board);
	}
}
