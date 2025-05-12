package likelion.likelion.repository;

import likelion.likelion.controller.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByID(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
