package com.js.vocatest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * The type Base entity.
 */

// 해당 클래스에 Auditing 기능을 포함
@EntityListeners(AuditingEntityListener.class)
@Getter

// JPA Entity 클래스들이 해당 추상 클래스를 상속할 경우 컬럼을 공통매핑 정보로 인식
@MappedSuperclass
public abstract class BaseEntity {
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @CreatedDate
    @Column(name = "create_at", columnDefinition = "timestamp with time zone", updatable = false)
    private LocalDateTime createAt;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @LastModifiedDate
    @Column(name = "update_at", columnDefinition = "timestamp with time zone")
    private LocalDateTime updateAt;
}
