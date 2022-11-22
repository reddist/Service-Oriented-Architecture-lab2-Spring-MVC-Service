package lab.reddist.lab2springmvc.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) // 404
public class PersonNotFoundException extends RuntimeException {}
