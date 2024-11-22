package konovalenko.studentsqueue.controllers.advice.exceptions;

import org.springframework.http.HttpStatus;

public class EmailAlreadyTakenException extends HttpStatusError{
    public EmailAlreadyTakenException() {
        super("This E-Mail is alredy taken", HttpStatus.CONFLICT);
    }
}
