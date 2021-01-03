package hello2021.hellospring.service;

import hello2021.hellospring.domain.Member;
import hello2021.hellospring.repository.MemberRepository;
import hello2021.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Gatsjy
 * @since 2021-01-03
 * realize dreams myself
 * Blog : https://blog.naver.com/gkswndks123
 * Github : https://github.com/gatsjy
 */

public class MemberService {

    private final MemberRepository memberRepository;

    // 외부에서 넣어주게 바꿔준다.
    // 스프링 빈을 등록하는 방식
    // 1. 컨포넌트 스캔
    // 2. 자바코드로 직접 스프링 빈 등록하기
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *  회원 가입
     */
    public Long join(Member member){

        // 같은 이름이 있는지 중복 회원 X
        // 중복 회원 검증 (ctrl + alt + t)
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 회원 조회
     * @param memberId
     * @return
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
