package konovalenko.studentsqueue.controllers.advice.exceptions;

import org.springframework.http.HttpStatus;

public class IncorrectUserDataException extends  HttpStatusError {

    public IncorrectUserDataException(String reason) {
        super(reason, HttpStatus.BAD_REQUEST);
    }

}
