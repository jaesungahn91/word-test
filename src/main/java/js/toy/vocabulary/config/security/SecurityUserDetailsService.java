package js.toy.vocabulary.config.security;

import js.toy.vocabulary.entity.User;
import js.toy.vocabulary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetails 정보 얻어냄
 */
@RequiredArgsConstructor
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /* email로 User 객체 생성 후 SecurityUser로 변환 */
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found by email : " + email));
        return new SecurityUser(user);
    }
}
