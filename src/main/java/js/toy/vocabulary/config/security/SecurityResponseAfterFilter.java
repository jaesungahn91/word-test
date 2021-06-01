package js.toy.vocabulary.config.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class SecurityResponseAfterFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("================== SecurityResponseAfterFilter 시작 ==================");

        String jwtToken =  jwtTokenProvider.getJwtFromRequest(request);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && StringUtils.isNotBlank(jwtToken)
                && jwtTokenProvider.validateToken(jwtToken) && jwtTokenProvider.isTokenExpired(jwtToken)) {
             response.setHeader("refresh-auth", jwtTokenProvider.createToken(authentication));
        }

        log.info("================== SecurityResponseAfterFilter 종료 ==================");
        filterChain.doFilter(request, response);
    }
}
