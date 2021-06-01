package js.toy.vocabulary.entity;

import lombok.*;

import javax.persistence.*;

/**
 * The type Voca.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
/* equals, hashCode 자동 생성 */
@EqualsAndHashCode(of = "seq", callSuper = false)
@Entity
@Table(name = "voca")
public class Voca extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", updatable = false, nullable = false)
    private Long seq;

    @Column(name = "word")
    private String word;

    @Column(name = "mean")
    private String mean;

}
