package js.toy.vocabulary.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import js.toy.vocabulary.config.response.ErrorResponse;
import js.toy.vocabulary.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * before filter
 * api 요청이 올때마다 통과할 필터.
 * 1. jwt 유효한지 체크
 * 2. jwt 만료됐을 경우 refresh token 넣어주기.(header)
 */
/* Filter는 Request 요청마다 한번씩 호출하는 OncePerRequestFilter */
@Slf4j
public class SecurityAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private SecurityUserDetailsService securityUserDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        log.info("================== SecurityAuthenticationFilter 시작 ==================");

        String jwtToken = jwtTokenProvider.getJwtFromRequest(request);

        /* jwt 없는 경우는 프리패스 => permit all */
        if (StringUtils.isBlank(jwtToken) || !jwtTokenProvider.validateToken(jwtToken)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String eamilFromToken = jwtTokenProvider.getEmailFromToken(jwtToken);
            UserDetails userDetails = securityUserDetailsService.loadUserByUsername(eamilFromToken);

            UsernamePasswordAuthenticationToken authentication =
                    /* 여기있는 super.setAuthenticated(true); 를 타야함. */
                    new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
//            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // 패턴인것 같은데 무슨역할인지 정확히는 모르겠음.
            SecurityContextHolder.getContext().setAuthentication(authentication);

            /* reqeust에 필요한 정보 저장 */
            request.setAttribute("email", eamilFromToken);
            request.setAttribute("seq", jwtTokenProvider.getSeqFromToken(jwtToken));

            log.info("================== SecurityAuthenticationFilter 종료 ==================");

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            ResponseUtil.writeJson(response, objectMapper, new ErrorResponse(400, "알 수 없는 에러가 발생하였습니다.", null));
            e.printStackTrace();
        }

    }
}
