package com.example.Todo.service;

import com.example.Todo.dto.tododto;

import java.util.List;

public interface todoservice {
    tododto addtodo(tododto tododto);
    tododto gettodo(Long id);
    List<tododto> getalltododto();
    tododto updatetodo(tododto tododto,Long id);
    void deletetodo(Long id);
    tododto comletetodo(Long id);
    tododto incompletetodo(Long id);
}
