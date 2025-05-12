package com.example.demo.service;

import com.example.demo.repository.MemberRepository;
import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void join(Member member){
        memberRepository.save(member);
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    public Member findOne(String memberName) {
        return memberRepository.findByName(memberName);
    }

}
