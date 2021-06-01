package js.toy.vocabulary.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import js.toy.vocabulary.config.response.ErrorResponse;
import js.toy.vocabulary.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 시큐리티 컨텍스트 내에 존재하는 인증절차
 * : 인증과정에서 실패하거나 인증헤더(Authorization)를 보내지 않게되는 경우 401(UnAuthorized) 라는 응답값을 처리해주는 로직
 */
@Component
@Slf4j
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    ObjectMapper objectMapper;

    private final ErrorResponse UNAUTHORIZED_RESPONSE = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "로그인이 만료되었습니다. \n다시 로그인해주시기 바랍니다.", null);

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.error("UNAUTHORIZED!! " + e.getMessage());

        /* response에 넣기(리팩토링) */
//        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
//        try (OutputStream os = httpServletResponse.getOutputStream()) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.writeValue(os, UNAUTHORIZED_RESPONSE);
//            os.flush();
//        }
        ResponseUtil.writeJson(httpServletResponse, objectMapper, UNAUTHORIZED_RESPONSE);
    }
}
