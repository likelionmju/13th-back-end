package com.example.week06_hw.repository;

import com.example.week06_hw.domain.Member;

import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    void save(Member member);
}
