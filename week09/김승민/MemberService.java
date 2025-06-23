package com.example.service;

import com.example.member.Member;
import com.example.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class MemberService {
    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member findMemberById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Member save(Member member){
        return repository.save(member);
    }

    public List<Member> findAllMembers() {
        return repository.findAll();
    }
}
