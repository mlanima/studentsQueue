package konovalenko.studentsqueue.controllers.advice.exceptions;


import org.springframework.http.HttpStatus;

public class QueueNameAlreadyTakenException extends HttpStatusError{
    public QueueNameAlreadyTakenException() {
        super("The queue name is already taken", HttpStatus.CONFLICT);
    }
}
