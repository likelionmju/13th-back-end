package com.example.practice0505.repository;

import com.example.practice0505.domain.Member;
import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    void save(Member member);
}