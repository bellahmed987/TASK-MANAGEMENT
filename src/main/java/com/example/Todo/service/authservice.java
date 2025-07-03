package com.example.Todo.service;

import com.example.Todo.dto.logindto;
import com.example.Todo.dto.regesterdto;

public interface authservice {
    String Regester(regesterdto regesterdto) ;
    String Login(logindto logindto);
}
