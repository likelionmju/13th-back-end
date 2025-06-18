package com.example.demo.repository;

import com.example.demo.domain.Bookmark;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryBookmarkRepository implements BookmarkRepository {
    // gpt
    private static class BookmarkKey {
        private UUID memberId;
        private UUID placeTag;

        public BookmarkKey(UUID memberId, UUID placeTag) {
            this.memberId = memberId;
            this.placeTag = placeTag;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BookmarkKey)) return false;
            BookmarkKey that = (BookmarkKey) o;
            return Objects.equals(memberId, that.memberId) &&
                    Objects.equals(placeTag, that.placeTag);
        }

        @Override
        public int hashCode() {
            return Objects.hash(memberId, placeTag);
        }
    }

    private static final Map<BookmarkKey, Bookmark> store = new HashMap<>();

    @Override
    public Bookmark save(Bookmark bookmark) {
        BookmarkKey key = new BookmarkKey(bookmark.getMemberId(), bookmark.getPlaceTag());
        store.put(key, bookmark);
        return bookmark;
    }

    @Override
    public Optional<Bookmark> findById(UUID memberId, UUID placeTag) {
        BookmarkKey key = new BookmarkKey(memberId, placeTag);
        return Optional.ofNullable(store.get(key));
    }
    // gpt
    @Override
    public List<Bookmark> findByField(String field, String value) {
        List<Bookmark> result = new ArrayList<>();
        for (Bookmark b : store.values()) {
            switch (field.toLowerCase()) {
                case "placeid":
                    if (b.getPlaceId().toString().equals(value)) {
                        result.add(b);
                    }
                    break;
                case "savedat":
                    if (b.getSavedAt().toString().contains(value)) {
                        result.add(b);
                    }
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}