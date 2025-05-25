package com.example.hello_spring2.repository;

import com.example.hello_spring2.domain.Member;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository {
    private static Map<String, Member> store = new HashMap<>();

    public Member save(Member member) {
        store.put(member.getName(), member);
        return member;
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public Member findByName(String name) {
        return store.get(name);
    }
}
