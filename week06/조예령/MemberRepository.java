package likelion.Member.repository;

import likelion.Member.domain.Member;
import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    Member save(Member member);

}