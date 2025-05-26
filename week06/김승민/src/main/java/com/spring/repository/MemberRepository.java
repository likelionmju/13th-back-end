package com.spring.repository;

import com.spring.model.Member;

import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    void save(Member member);
}
