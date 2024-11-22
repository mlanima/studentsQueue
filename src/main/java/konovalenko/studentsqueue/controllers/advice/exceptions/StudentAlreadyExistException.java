package konovalenko.studentsqueue.controllers.advice.exceptions;

import org.springframework.http.HttpStatus;

public class StudentAlreadyExistException extends HttpStatusError{
    public StudentAlreadyExistException(Long studentId) {
        super("Student with Id: " + studentId + "already exists", HttpStatus.CONFLICT);
    }
}
