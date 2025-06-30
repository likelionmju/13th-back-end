package com.example.spring_project.repository;

import com.example.spring_project.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //
//    Optional<Member> findById(Long id);
//    Optional<Member> findByName(String name);
    List<Member> findAll();
}
