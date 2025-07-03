package com.example.Todo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor

public class todoapiexception extends RuntimeException
{
    private HttpStatus status;
    private String message;
}
