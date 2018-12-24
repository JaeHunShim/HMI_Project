package hi.proejct.management.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("target");// 엔티티매니저팩토리 생성
		
		EntityManager em = emf.createEntityManager(); // 엔티티매니저 생성
		
		EntityTransaction tx= em.getTransaction();
		
		try {
			tx.begin();
			logic(em);
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
	private static void logic(EntityManager em) {
		
	}
}
