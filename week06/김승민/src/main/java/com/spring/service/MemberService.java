package com.spring.service;

import com.spring.model.Member;
import com.spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void register(Member member) {
        if (memberRepository.findByName(member.getName()) != null) {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        }
        memberRepository.save(member);
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Member findMemberByName(String name) {
        return memberRepository.findByName(name);
    }
}