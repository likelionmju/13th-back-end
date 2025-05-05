package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// @Repository
public class MemoryMemberRepository implements MemberRepository {
    // 회원 정보를 저장해두는 메모리 창고
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // Optional.ofNullable()로 감싸서, null일 수도 있다는 걸 안전하게 표현
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // store.values() → Map 안에 있는 회원들 전부 가져옴
        // .stream() → 리스트처럼 반복 가능한 형태로 변환
        return store.values().stream() // 회원 이름이 찾는 이름과 같은지 확인
                .filter(member -> member.getName().equals(name))
                .findAny(); // .findAny() → 조건에 맞는 회원이 하나라도 있으면 Optional로 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // List(ArrayList)는 “순차적으로 데이터를 저장하고 꺼내기 위한 리스트”
        // 데이터를 전부 꺼내서 보여줄 땐 → List가 편함 (순서, 크기, 반복 등)

    }

    public void clearStore() {
        store.clear();
    }
}