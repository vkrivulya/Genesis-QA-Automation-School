package pages.homework06;

public class CustomException extends RuntimeException {

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(String message) {
        super(message);
    }
}
