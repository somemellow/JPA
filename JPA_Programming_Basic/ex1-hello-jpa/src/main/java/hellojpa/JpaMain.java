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
            //Code 저장
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);
            //조회 Code
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
            //삭제 Code
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);
            //수정 Code
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
            //JPQL(객체지향 SQL)
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();
            for(Member member : result){
                System.out.println("member.getName() = " + member.getName());
            }

            tx.commit();    
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();            
        }
        
        emf.close();
    }
}
