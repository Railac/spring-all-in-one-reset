package com.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication //시작점
public class Application {
    public static void main(String[] args) {
        //내장Was (웹서버) 실행
        SpringApplication.run(Application.class, args);
    }
}