package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @Before
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @After
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입() {
        //given
        Member member = new Member();
        member.setName("gihyun");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);

        //then
    }
    @Test
    public void findMembers() {
    }

    @Test
    public void findOne() {
    }
}