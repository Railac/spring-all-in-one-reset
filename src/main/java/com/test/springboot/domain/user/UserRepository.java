package com.test.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); //소셜 로그인의 email값을 받아, 이미생성된 사용자인지 확인
}
