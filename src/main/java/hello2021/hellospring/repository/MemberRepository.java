package hello2021.hellospring.repository;

import hello2021.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

/**
 * @author Gatsjy
 * @since 2021-01-03
 * realize dreams myself
 * Blog : https://blog.naver.com/gkswndks123
 * Github : https://github.com/gatsjy
 */
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
