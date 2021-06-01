package js.toy.vocabulary.service;

import js.toy.vocabulary.dto.response.UserResult;
import js.toy.vocabulary.entity.User;
import js.toy.vocabulary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResult getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다."));
        return new UserResult(user);
    }
}
