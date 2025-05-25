package com.example.hello_spring.repository;

import com.example.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private final List<Member> members = new ArrayList<>();

    public void save(Member member) {
        members.add(member);
    }

    public Member findByName(String name) {
        for (Member m : members) {
            if (m.getName().equals(name)) return m;
        }
        return null;
    }

    public List<Member> findAll() {
        return members;
    }
}