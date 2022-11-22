package lab.reddist.lab2springmvc.controller.exception;

import lab.reddist.lab2springmvc.dto.response.ErrorMessage;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PersonNotFoundException.class)
    protected ResponseEntity<ErrorMessage> handlePersonNotFound () {
        return new ResponseEntity<>(new ErrorMessage("Person not found"), HttpStatus.valueOf(404));
    }

    @ExceptionHandler(InvalidIdException.class)
    protected ResponseEntity<ErrorMessage> handleInvalidId () {
        return new ResponseEntity<>(new ErrorMessage("Invalid ID supplied"), HttpStatus.valueOf(400));
    }
}
