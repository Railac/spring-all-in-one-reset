package com.test.springboot.web;

import com.test.springboot.service.posts.PostsService;
import com.test.springboot.web.dto.PostsResponseDto;
import com.test.springboot.web.dto.PostsSaveRequestDto;
import com.test.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController //json형태 반환, 과거 @Responsebody
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") //저장
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") //update
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
