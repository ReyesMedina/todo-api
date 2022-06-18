package dev.rmpedro.app.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExcHandler {
    @ExceptionHandler(value = TodoExceptions.class)
    public ResponseEntity<?> notFoundException(TodoExceptions ex) {
        Map<String, Object> answer = new HashMap<String, Object>();
        answer.put("error", ex.getMessage());
        return new ResponseEntity<>(answer, HttpStatus.NOT_FOUND);
    }
}
