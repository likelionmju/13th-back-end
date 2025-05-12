package com.example.practice0505.repository;

import com.example.practice0505.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements com.example.practice0505.repository.MemberRepository {
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