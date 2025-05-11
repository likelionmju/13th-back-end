package com.example.hello_spring2.service;

import com.example.hello_spring2.domain.Member;
import com.example.hello_spring2.repository.MemberRepository;
import com.example.hello_spring2.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원등록
     */
    public String join(Member member) {
        memberRepository.save(member);
        return member.getName();
    }
    
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 한명 조회
     */
    public Member findOne(String name) {
        return memberRepository.findByName(name);
    }
}