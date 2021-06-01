package js.toy.vocabulary.entity;

import lombok.*;

import javax.persistence.*;

/**
 * The type User.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
/* equals, hashCode 자동 생성 */
@EqualsAndHashCode(of = "seq", callSuper = false)
@Entity
@Table(name = "user",
        /* 인덱스 설정 */
        indexes = {
            @Index(name = "user_email_idx", unique = true, columnList = "email")
        }
)
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", updatable = false, unique = false)
    private Long seq;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;
}
