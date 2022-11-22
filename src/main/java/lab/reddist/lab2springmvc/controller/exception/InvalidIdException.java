package lab.reddist.lab2springmvc.controller.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST) // 400
public class InvalidIdException extends RuntimeException {}
