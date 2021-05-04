package js.toy.vocabulary.config.security;

import js.toy.vocabulary.config.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 시큐리티 컨텍스트 내에 존재하는 인증절차
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "UnAuthorized!!!", null);

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

    }
}
