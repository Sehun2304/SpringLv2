package com.sparta.springlv2.dto;

import lombok.Getter;

import java.util.List;


//글 목록을 list 형식으로 반환
@Getter
public class PostListResponseDto {
    private List<PostResponseDto> postsList;

    public PostListResponseDto(List<PostResponseDto> postList) {
        this.postsList = postList;
    }
}