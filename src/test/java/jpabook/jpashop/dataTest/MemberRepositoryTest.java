package jpabook.jpashop.dataTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    // TEST에 해당 어노테이션이 있으면 Rollback한다.
    // Rollback 기능 끄는 법
    // @Rollback(false)
    void testMember() throws Exception{
        Member member = new Member();
        member.setUsername("newMember123");
        
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        
        // 식별자가 같기 때문에 같다(isEqualTo -> true)
        // +) 같은 트랜잭션 
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}
