package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{

           Member member = new Member();
           member.setUsername("user1");
           member.setCreateBy("Kim");
           member.setCreateDate(LocalDateTime.now());

            em.persist(member);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = " + findMovie);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();            
        }
        
        emf.close();
    }
}
