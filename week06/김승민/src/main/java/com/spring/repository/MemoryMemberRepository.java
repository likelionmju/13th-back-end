package com.spring.repository;

import com.spring.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static AtomicLong sequence = new AtomicLong(0L);

    @Override
    public void save(Member member) {
        member.setId(sequence.incrementAndGet());
        store.put(member.getId(), member);
    }

    @Override
    public Member findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}