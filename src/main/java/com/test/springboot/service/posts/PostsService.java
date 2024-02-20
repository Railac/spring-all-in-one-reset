package com.test.springboot.service.posts;

import com.test.springboot.domain.posts.Posts;
import com.test.springboot.domain.posts.PostsRepository;
import com.test.springboot.web.dto.PostsResponseDto;
import com.test.springboot.web.dto.PostsSaveRequestDto;
import com.test.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //필요한 생성자 생성해줌 여기선 final 필드
@Service
public class PostsService {

    private final PostsRepository postsRepository; //autowire가없는 이유는 JpaRepository 상속시 자동 빈등록.

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){ //쿼리를 날리는 부분이없다., JPA의 영속성 컨텍스트라서
        Posts posts = postsRepository.findById(id).orElseThrow( //id값으로 검색하고, 없으면  아래로그 출력
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id ));

        posts.update(requestDto.getTitle(), requestDto.getContent()); //entity의 메소드 호출
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
