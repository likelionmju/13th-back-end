package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;
import java.util.List;

@Repository
public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    void save(Member member);
}