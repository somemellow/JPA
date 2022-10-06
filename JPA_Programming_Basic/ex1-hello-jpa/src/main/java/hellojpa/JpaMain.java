package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{

            //JPQL
            //select m from Member m where m.age > 18
            JPAFactoryQuery query = new JPAQueryFactory(em);
            QMember m = QMember.member;

            List<Member> list = query.selectFrom(m).where(m.age.gt(18)) .orderBy(m.name.desc()).fetch();
            tx.commit();

        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();            
        }
        emf.close();
    }
}
