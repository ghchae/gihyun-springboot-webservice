package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
        회원가입
        회원가입시 중복되는 회원X
     */
    public Long join(Member member) {

        validateDuplicateMember(member);

        memberRepository.save(member);
            return member.getId();
        }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }
    // 값이있으면, 이미존재하는 회원입니다라고 보내라 optional 이기 때문에 가능하다. optional을쓰면 if(null)을 안써도된다
    // 여기서 findByName해서 로직이쭉나온다? 이런경우, 메소드로 뽑는게 좋다 -> ctrl + alt + shift + t 단축키를 이용해서 리팩토링
    //Optional<Member> result = memberRepository.findByName(member.getName()); alt + ctrl + v 자동완성
    //optional을 반환하는게 좋아보이지않는다. 그래서 ifPresent를 바로 붙인다.
    /**
     * 전체 회원 조회
     */

}

