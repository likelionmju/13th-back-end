package com.example.hellospring.repository;

import com.example.hellospring.entity.Member;

import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    Member save(Member member);
}
