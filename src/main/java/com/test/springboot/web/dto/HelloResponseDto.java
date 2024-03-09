package com.test.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor //final 가진 필드 생성자생성
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
