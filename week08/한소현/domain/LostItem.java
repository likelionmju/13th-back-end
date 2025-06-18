package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LostItem {
    private Long memberId;
    private Long itemId;
    private String itemName;
    private String division;
    private String lostAddress;
    private String  lostTime;
    private LostItemStatus status;
    private String  saveTime;

    public void setStatus(String status){
        if (status.equals("FINDING")){
            this.status=LostItemStatus.FINDING;
        } else if (status.equals("FIND")) {
            this.status = LostItemStatus.FIND;
        } else if (status.equals("RETURNED")) {
            this.status = LostItemStatus.RETURNED;
        }
    }
}
