package com.example.likelioncatchit.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LostItem {

    //포스트맨에서 id 직접 지정
    @Id
    private Long itemId;

    private Long memberId;
    private String itemName;
    private String division;
    private String lostAddress;
    private String  lostTime;
    private LostItemStatus status;
    private String  saveTime;

}
