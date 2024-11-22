package konovalenko.studentsqueue.controllers.advice.exceptions;

import org.springframework.http.HttpStatus;


public abstract class HttpStatusError extends RuntimeException {

    private final HttpStatus status;

    public HttpStatusError(String reason, HttpStatus status) {
        super(reason);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
