package hello.week06.repository;

import hello.week06.model.Member;
import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    void save(Member member);
}
