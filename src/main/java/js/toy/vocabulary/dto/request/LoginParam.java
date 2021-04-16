package js.toy.vocabulary.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class LoginParam {
    private String email;
    private String password;
}
