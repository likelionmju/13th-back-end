package likelion.Member.repository;

import likelion.Member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<String, Member> store = new HashMap<>();

    /**
     * @return
     */
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Member findByName(String name) {
        return store.get(name);
    }

    /**
     * @param member
     * @return
     */
    @Override
    public Member save(Member member) {
        store.put(member.getName(), member);
        return member;
    }
}
