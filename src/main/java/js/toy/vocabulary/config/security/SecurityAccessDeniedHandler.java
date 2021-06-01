package js.toy.vocabulary.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import js.toy.vocabulary.config.response.ErrorResponse;
import js.toy.vocabulary.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class SecurityAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    ObjectMapper objectMapper;

    private final ErrorResponse FORBIDDEN_RESPONSE = new ErrorResponse(HttpStatus.FORBIDDEN.value(), "해당 리소스에 접근하실 수 없습니다.", null);

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        log.error("ACCESS DENIED!! " + e.getMessage());

        /* response에 넣기 (리팩토링)*/
//        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
//        try (OutputStream os = httpServletResponse.getOutputStream()) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.writeValue(os, errorResponse);
//            os.flush();
//        }
        ResponseUtil.writeJson(httpServletResponse, objectMapper, FORBIDDEN_RESPONSE);

    }
}
