package com.example.Todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class globalexception {
    @ExceptionHandler(todoapiexception.class)
    public ResponseEntity<erordetails> handleexception(todoapiexception todoapiexception, WebRequest webRequest){
        erordetails erordetails=new erordetails(
                LocalDateTime.now(),
                todoapiexception.getMessage(),
                webRequest.getDescription(false)
        );
        return  new ResponseEntity<>(erordetails, HttpStatus.BAD_REQUEST);
    }
}
