package com.example.spring_project.service;

import com.example.spring_project.domain.Member;
import com.example.spring_project.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join (Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        List result = memberRepository.findAll();
        return result;
    }


}
