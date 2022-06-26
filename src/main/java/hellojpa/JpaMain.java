package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();

        tx.begin();
        try {
            Member member = new Member();

            member.setId(2L);

            member.setName("HelloA");

            List<Member> result = entityManager.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for (Member member1 : result) {
                System.out.println("member1.getName() = " + member1.getName());
            }

            /*Member findMember = entityManager.find(Member.class, 1L);
            findMember.setName("HelloJpa");*/

            /* 제거
            entityManager.remove(findMember);*/
            /* 조회
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());
            */

            /*
            entityManager.persist(member); 회원 저장
            */

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}