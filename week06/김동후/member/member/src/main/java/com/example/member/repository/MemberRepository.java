package com.example.member.repository;

import com.example.member.domain.Member;
import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    void save(Member member);
}
