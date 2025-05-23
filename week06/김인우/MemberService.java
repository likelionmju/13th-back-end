package com.example.hellospring.service;

import com.example.hellospring.entity.Member;
import com.example.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private static final int ADULT_AGE = 20;

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member findByName(String name) {
        return memberRepository.findByName(name);
    }

    public Member save(Member member) {
        if(duplicatedNameCheck(member)) return null;
        setAdult(member);
        return memberRepository.save(member);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    private boolean duplicatedNameCheck(Member member) {
        Member duplicatedMember = memberRepository.findByName(member.getName());
        if(duplicatedMember!=null){
            return true;
        }
        return false;
    }

    private static void setAdult(Member member) {
        member.setAdult(member.getAge() >= ADULT_AGE);
    }
}
