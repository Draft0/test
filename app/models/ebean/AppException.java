package models.ebean;

/**
 * Created by Draft on 24.04.2017.
 */
public class AppException extends Exception {

    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }


}
