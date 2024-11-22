package konovalenko.studentsqueue.controllers.advice.exceptions;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends HttpStatusError {


    public StudentNotFoundException(){
        super("Student not found", HttpStatus.NOT_FOUND);
    }

}
