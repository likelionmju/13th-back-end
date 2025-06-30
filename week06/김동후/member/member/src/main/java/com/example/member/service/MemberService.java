package com.example.member.service;

import com.example.member.domain.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void register(Member member) {
        repository.save(member);
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Member findMember(String name) {
        return repository.findByName(name);
    }
}
