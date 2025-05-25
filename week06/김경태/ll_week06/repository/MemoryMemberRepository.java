package com.example.ll_week06.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static final List<Member> members = new ArrayList<>();

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public Member findByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public void save(Member member) {
        members.add(member);
    }
}
