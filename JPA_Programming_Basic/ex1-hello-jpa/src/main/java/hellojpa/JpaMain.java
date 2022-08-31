package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{

            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZ");
//            em.persist(member); persist를 할 필요 없다 왜냐면 JPA는 객체를 자바 컬렉션 처럼 쓰기위하기 때문이다.

            System.out.println("============================");

            tx.commit();    
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();            
        }
        
        emf.close();
    }
}
