package com.example.hello_spring.repository;
import com.example.hello_spring.domain.Member;

import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    void save(Member member);
}