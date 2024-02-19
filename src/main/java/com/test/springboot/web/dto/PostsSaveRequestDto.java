package com.test.springboot.web.dto;

import com.test.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor //기본생성자 생성
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){ //객체 생성
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
