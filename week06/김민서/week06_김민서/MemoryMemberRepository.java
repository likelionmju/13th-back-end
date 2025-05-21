package hello.week06.repository;

import hello.week06.model.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private final Map<String, Member> store = new HashMap<>();

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Member findByName(String name) {
        return store.get(name);
    }

    @Override
    public void save(Member member) {
        store.put(member.getName(), member);
    }
}

