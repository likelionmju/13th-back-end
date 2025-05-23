package com.example.hello_spring.service;
import com.example.hello_spring.domain.Member;
import com.example.hello_spring.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void save(Member member) {
        repository.save(member);
    }

    public Member findByName(String name) {
        return repository.findByName(name);
    }

    public List<Member> findAll() {
        return repository.findAll();
    }
}