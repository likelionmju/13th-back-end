package com.example.week08assignment.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // 기본 생성자와 (파라미터 X) 모든 필드를 파라미터로 받는 생성자는 Lombok으로 생략도 가능하다.
public class LostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lostId;
    private Long userId;
    private String description;
    private String lostTime;
    private String lostLocation;
    private String storagePlace;
}
