package com.example.likelioncatchit.Repository;

import com.example.likelioncatchit.Model.LostItem;
import com.example.likelioncatchit.Model.LostItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LostItemRepository extends JpaRepository<LostItem, Long> {
    List<LostItem> findByStatus(LostItemStatus status); //상태별 리스트 반환
    List<LostItem> findByMemberId(Long memberId); //회원별 리스트 반환

    //상태 변경
    //동적 쿼리 사용
    @Modifying
    @Query("UPDATE LostItem L SET L.status = :status WHERE L.itemId = :itemId")
    void update(@Param("itemId") Long itemId, @Param("status") LostItemStatus status);
}
