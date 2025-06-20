package com.example.demo.domain;

import java.util.Date;
import java.util.UUID;

public class Bookmark {
    private UUID memberId;
    private UUID placeTag;
    private Integer placeId;
    private Date savedAt;

    public Bookmark() {}

    public Bookmark(UUID memberId, UUID placeTag, Integer placeId, Date savedAt) {
        this.memberId = memberId;
        this.placeTag = placeTag;
        this.placeId = placeId;
        this.savedAt = savedAt;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
    }

    public UUID getPlaceTag() {
        return placeTag;
    }

    public void setPlaceTag(UUID placeTag) {
        this.placeTag = placeTag;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Date getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(Date savedAt) {
        this.savedAt = savedAt;
    }
}