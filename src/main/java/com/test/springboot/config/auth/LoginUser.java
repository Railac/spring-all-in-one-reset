package com.test.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // LoginUser라는 어노테이션이 생성될수있는 위치를 설정, 파라미터로 지정했으니 메소드 파라미터로 사용가능
@Retention(RetentionPolicy.RUNTIME) //해당 어노테이션의 보관기간을 나타낸다. 런타임이 끝날때까지 남아있는다.
public @interface LoginUser { //해당 파일을 어노테이션 클래스로 지정한다.
}
