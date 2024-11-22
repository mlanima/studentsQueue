package konovalenko.studentsqueue.controllers.advice;

import konovalenko.studentsqueue.controllers.advice.exceptions.HttpStatusError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class GlobalControllerAdvice {


    @ExceptionHandler
    public ResponseError handleException(HttpStatusError exception) {
        return new ResponseError(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseError illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        //ErrorResponse is the custom response model
        return new ResponseError(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
