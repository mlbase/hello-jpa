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
            /*Member member = new Member();
            member.setId(3L);
            member.setUsername("c");
            member.setRoleType(RoleType.user);

            entityManager.persist(member);*/

            //준영속(half persistence)
            /*Member member = entityManager.find(Member.class, 150L);// db조회하는 순간 영속성 생성
            member.setUsername("AAAA");

            //entityManager.detach(member);
            entityManager.clear();
            Member member2 = entityManager.find(Member.class, 150L);*/// clear하는 순간 cache data도 초기화
            //flush entity 내용과 db를 동기화하는 개(entity manager를 비우지 않음!)
            /*Member member = new Member(200L, "meber 200");
            entityManager.persist(member);
            entityManager.flush();
            System.out.println("=====================");*/

            //dirty checking
            /*Member member = entityManager.find(Member.class, 150L);
            member.setName("7777");
            System.out.println("=========================");*/

            //entityManager.persist(member);

//            //jpa 쓰기 지연
//            Member member1 = new Member( 150L, "A");
//            Member member2 = new Member( 160L, "B");
//
//            entityManager.persist(member1);
//            entityManager.persist(member2);
//            System.out.println("=========================");
            /*Member findMember1 = entityManager.find(Member.class, 100L);
            Member findMember2 = entityManager.find(Member.class, 100L);

            System.out.println("result = " + (findMember2 == findMember1));*/
            /*Member member = new Member();

            member.setId(100L);

            member.setName("HelloJPA");


            System.out.println("=== BEFORE ===");
            entityManager.persist(member);
            System.out.println("====AFTER====");*/
            /*
            List<Member> result = entityManager.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for (Member member1 : result) {
                System.out.println("member1.getName() = " + member1.getName());
            }*/

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
