package com.test.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role { //서로연관된 상수들의 집합
    //시큐리티에서는 권한 코드에 항상 ROLE_이 앞에 붙어 있어야 한다.
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
