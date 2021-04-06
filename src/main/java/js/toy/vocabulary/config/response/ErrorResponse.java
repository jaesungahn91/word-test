package js.toy.vocabulary.config.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The type Error response.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int code;
    private String message;
    private List<String> errorDetails;
    private String responseTime;

    /**
     * Instantiates a new Error response.
     *
     * @param code         the code
     * @param message      the message
     * @param errorDetails the error details
     */
    public ErrorResponse(int code, String message, List<String> errorDetails) {
        this.code = code;
        this.message = message;
        this.errorDetails = errorDetails;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }
}
