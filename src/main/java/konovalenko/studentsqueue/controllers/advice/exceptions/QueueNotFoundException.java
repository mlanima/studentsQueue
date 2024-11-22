package konovalenko.studentsqueue.controllers.advice.exceptions;

import org.springframework.http.HttpStatus;

public class QueueNotFoundException extends HttpStatusError{
    public QueueNotFoundException() {
        super("Queue Not Found", HttpStatus.NOT_FOUND);
    }
}
