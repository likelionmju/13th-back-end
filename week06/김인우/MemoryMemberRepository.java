package com.example.hellospring.repository;

import com.example.hellospring.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private final List<Member> members = new ArrayList<>();


    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public Member findByName(String name) {
        for(Member member : members) {
            if(member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public Member save(Member member) {
        members.add(member);
        return member;
    }
}
