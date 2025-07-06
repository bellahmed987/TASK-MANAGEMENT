package com.example.Todo.controller;

import com.example.Todo.dto.logindto;
import com.example.Todo.dto.regesterdto;
import com.example.Todo.service.authservice;
import com.example.Todo.service.authserviceimpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173") // 👈 THIS IS REQUIRED
@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
public class authcontroller {
    private  authservice authservice;
@PostMapping("/regester")
    public ResponseEntity<String> regester(@RequestBody regesterdto regesterdto){
        String res=authservice.Regester(regesterdto);
        return  new ResponseEntity<>(res,HttpStatus.CREATED);
                }
                @PostMapping("/login")
                public  ResponseEntity<String> login(@RequestBody logindto logindto){
    String res=authservice.Login(logindto);
    return  new ResponseEntity<>(res,HttpStatus.OK);
                }
}
