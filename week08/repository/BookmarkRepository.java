package com.example.demo.repository;

import com.example.demo.domain.Bookmark;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookmarkRepository {

    // 1. 새로운 객체 등록하기
    Bookmark save(Bookmark bookmark);

    // 2. 식별값으로 검색 (memberId + placeTag가 복합키 느낌이므로 둘 다 받음)
    Optional<Bookmark> findById(UUID memberId, UUID placeTag);

    // 3. 필드값으로 검색 (예: placeId로 모든 북마크 찾기 등)
    List<Bookmark> findByField(String field, String value);
}