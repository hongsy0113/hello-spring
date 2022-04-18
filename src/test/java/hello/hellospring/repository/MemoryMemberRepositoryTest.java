package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 메써드 실행이 끝날 때 마다 실행되는 메서드
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    // 이 메써드를 그냥 실행해보면 됨. 저장이 잘 되는지 테스트해보자자
   @Test
    public void save(){
       Member member = new Member();
       member.setName("spring");

       repository.save(member);

       Member result = repository.findById(member.getId()).get();
       // assertion 만족 못 시키면 run해서 빨간 색 뜸
       //Assertions.assertEquals(member, null);
       assertThat(member).isEqualTo((result));
   }

   @Test
    public void findByName(){
       Member member1 = new Member();
       member1.setName("spring1");
       repository.save(member1);

       Member member2 = new Member();
       member2.setName("spring2");
       repository.save(member2);

       //get()을 쓰면 option을 한 번 까서 꺼낼 수 있다고 함함
       Member result = repository.findByName("spring1").get();

       assertThat(result).isEqualTo((member1));
   }

   @Test
    public void findAll() {
       Member member1 = new Member();
       member1.setName("spring1");
       repository.save(member1);

       Member member2 = new Member();
       member2.setName("spring2");
       repository.save(member2);

       List<Member> result = repository.findAll();

       assertThat(result.size()).isEqualTo(2);
   }
}
