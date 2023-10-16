package br.com.nicolas.todolist.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // classe que irá receber todas as exceções
public class ExceptionHandlerController {

    @ExceptionHandler({HttpMessageNotReadableException.class}) // tipo de exceção que irá cair aqui
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMostSpecificCause().getMessage());


    }
}



