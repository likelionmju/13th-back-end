package com.example.practice0505.domain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LostItem {
    private int lostItemId;
    private int userId;
    private String name;
    private String category;
    private String lostDate;
    private boolean findItem;
    private String findDate;

    public LostItem() {}

    public LostItem(int lostItemId, int userId, String name, String category, String lostDate) {
        this.lostItemId = lostItemId;
        this.userId = userId;
        this.name = name;
        this.category = category;
        this.lostDate = lostDate;
        this.findItem = false;
        this.findDate = "";
    }
}
