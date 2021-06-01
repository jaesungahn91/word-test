package js.toy.vocabulary.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import js.toy.vocabulary.config.response.ErrorResponse;
import org.springframework.hateoas.MediaTypes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* 에러 Response 처리 부분 */
public class ResponseUtil {

    public static void writeJson(HttpServletResponse httpServletResponse, ObjectMapper objectMapper, ErrorResponse errorResponse) throws IOException {
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType(MediaTypes.HAL_JSON_VALUE);
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
