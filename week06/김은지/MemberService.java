package com.example.week06_hw.service;

import com.example.week06_hw.domain.Member;
import com.example.week06_hw.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    //스프링의 자동 관리 기능으로 new MemoryMemberRepository() 대신..
    private final MemberRepository memberRepository; //을 쓸 수 있음..(?)

    public MemberService(MemberRepository memberRepository) {//생성자,
        this.memberRepository = memberRepository;
    }

    public void register(Member member) { //등록
        //이름 중복된다면 등록 금지
        if (memberRepository.findByName(member.getName()) != null) {
            // 중복회원이라면 duplicate.html 보여줌
            throw new IllegalStateException("duplicate");
        }
        memberRepository.save(member);
    }

    public Member findOne(String name) { //한 명만 찾을 때
        return memberRepository.findByName(name);
    }

    public List<Member> findAll() { //전체 리스트 확인
        return memberRepository.findAll();
    }

}
