package konovalenko.studentsqueue.controllers.advice.exceptions;

import org.springframework.http.HttpStatus;

public class QueueMemberNotFound extends HttpStatusError{
    public QueueMemberNotFound() {
        super("Queue member not found", HttpStatus.NOT_FOUND);
    }
}
