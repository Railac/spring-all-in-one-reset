package com.test.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //해당 클래스를 상속받는경우, 필드들도 컬럼으로 인식시킨다.
@EntityListeners(AuditingEntityListener.class) //Auditing기능 포함
public abstract class BaseTimeEntity {

    @CreatedDate //생성시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 값 변경시 시간 자동 저장
    private LocalDateTime modifieDate;
}
