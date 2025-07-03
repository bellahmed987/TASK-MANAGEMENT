package com.example.Todo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class erordetails {
 private LocalDateTime timestamp;
 private String msg;
 private String details;
}
