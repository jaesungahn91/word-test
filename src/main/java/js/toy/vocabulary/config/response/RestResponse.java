package js.toy.vocabulary.config.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Rest response.
 *
 * @param <T> the type parameter
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> {

    private int code;
    private String message;
    private T result;
    private String responseTime;

    /**
     * Instantiates a new Rest response.
     *
     * @param code    the code
     * @param message the message
     * @param result  the result
     */
    public RestResponse(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }
}
