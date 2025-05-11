package com.example.hello_spring2.repository;

import com.example.hello_spring2.domain.Member;
import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    void save(Member member);
}
