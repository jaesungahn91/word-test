package com.js.vocatest.entity;

import lombok.*;

import javax.persistence.*;

/**
 * The type Voca.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

// equals, hashCode 자동 생성
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "voca")
public class Voca extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voca_id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "word")
    private String word;
    @Column(name = "mean")
    private String mean;
}
