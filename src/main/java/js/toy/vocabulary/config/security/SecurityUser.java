package js.toy.vocabulary.config.security;

import js.toy.vocabulary.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Spring Security 인증 유저 객체
 */
public class SecurityUser implements UserDetails {

    private Long seq;
    private String email;
    private String password;
    private User user;

    /**
     * Instantiates a new Security user.
     */
    public SecurityUser() {}

    /**
     * Instantiates a new Security user.
     *
     * @param user the user
     */
    public SecurityUser(User user) {
        this.seq = user.getSeq();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
//        return this.password;
        return "test";
    }

    @Override
    public String getUsername() {
//        return this.email;
        return "test";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
