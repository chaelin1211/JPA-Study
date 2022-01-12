package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
// Component Scan
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;
    // Spring이 생성한 EntityManager를 주입 받는다.
    // PersistenceUnit으로 직접 EntityManagerFactory를 주입 받을 수 있음

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        // 단건 조회
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        // JPQL
        // from의 대상이 테이블이 아니라 Entity
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
