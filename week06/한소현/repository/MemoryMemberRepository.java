package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Member findByName(String name) {
        Optional<Member> result = store.values().stream()
                .filter(member -> member.getName().equals(name)).findAny();
        return result.get();

    }

    @Override
    public void save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
    }
}
