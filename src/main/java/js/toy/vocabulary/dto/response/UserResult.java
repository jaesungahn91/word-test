package js.toy.vocabulary.dto.response;

import js.toy.vocabulary.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class UserResult {
    private String email;
    private String nickname;

    public UserResult(User user) {
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
