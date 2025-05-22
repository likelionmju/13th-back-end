package com.example.practice0505.service;

import com.example.practice0505.domain.Member;
import com.example.practice0505.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void register(String name, int age) {
        if (memberRepository.findByName(name) != null) {
            throw new IllegalArgumentException("중복된 이름입니다.");
        }
        memberRepository.save(new Member(name, age));
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member findByName(String name) {
        return memberRepository.findByName(name);
    }
}
