package com.test.springboot.config.auth;

import com.test.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //spring security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable() //h2-console화면을 사용하기 위해 해당옵션 비활성화
                .and().authorizeRequests() //URL별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //전체 열람권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //antMatcher: 권한관리대상을 지정, USER롤 가진사람만
                .anyRequest().authenticated() //설정된 값들 이외 나머지 URL,인증된 사용자(로그인한사람)들에게만 허용
                .and().logout().logoutSuccessUrl("/") //로그아웃 기능에 대한 설정의 진입점, 로그아웃성공시 /주소로 이동
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
                //로그인 성공 이후 사용자 정보를 가져올떄의 설정들을 담당, 소셜 로그인 성공시 후속조치를 진행할 UserService구현체 등록

    }
}
