package com.example.ll_week06.service;

import com.example.ll_week06.repository.Member;
import com.example.ll_week06.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemoryMemberRepository memoryMemberRepository;

    @Autowired
    public MemberService(MemoryMemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }

    public Member findByName(String name) {
        return memoryMemberRepository.findByName(name);
    }

    public void save(Member member) {
        memoryMemberRepository.save(member);
    }

    public List<Member> findAll() {
        return memoryMemberRepository.findAll();
    }
}
