package com.example.ll_week06.repository;
import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member findByName(String name);
    void save(Member member);
}