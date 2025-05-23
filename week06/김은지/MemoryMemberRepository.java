package com.example.week06_hw.repository;

import com.example.week06_hw.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MemoryMemberRepository implements MemberRepository {
    private final Map<String, Member> store=new HashMap<>();
    //key:홍길동 value:(홍길동, 20) 이런식으로 저장됨
    public void save(Member member) {
        store.put(member.getName(), member); //key에는 이름, value에는 객체를 저장
    }
    public Member findByName(String name){
        return store.get(name); //key인 이름으로 정보를 찾음
    }
    public List<Member> findAll(){//모든 멤버를 리스트로 리턴
        return new ArrayList<>(store.values());
    }

}
