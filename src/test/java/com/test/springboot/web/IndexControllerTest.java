package com.test.springboot.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@ExtendWith(SpringExtension.class) //테스트시 JUnit 내장 말고 지정해준 실행자로 테스트
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired private TestRestTemplate restTemplate;

    @Test
    @DisplayName("메인페이지_로딩")
    void index() {
        //when

        String body = this.restTemplate.getForObject("/", String.class);

        //then
        Assertions.assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}