package likelion.Member.service;

import likelion.Member.repository.MemberRepository;

import likelion.Member.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member searchMember(String name) {
        return memberRepository.findByName(name);
    }

    public String registerMember(Member member) {
        memberRepository.save(member);
        return member.getName();
    }

    public List<Member> listMember() {
        return memberRepository.findAll();
    }
}
