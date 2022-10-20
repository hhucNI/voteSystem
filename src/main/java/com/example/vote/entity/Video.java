package com.example.vote.entity;

import lombok.Data;

@Data
public class Video {
    private int videoId;
    private int num;
    private String url;
    private String description;
    private String organization;
}
