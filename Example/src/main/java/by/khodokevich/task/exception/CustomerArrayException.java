package by.khodokevich.task.exception;

public class CustomerArrayException extends Exception {
    public CustomerArrayException() {
    }

    public CustomerArrayException(String message) {
        super(message);
    }

    public CustomerArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerArrayException(Throwable cause) {
        super(cause);
    }
}
