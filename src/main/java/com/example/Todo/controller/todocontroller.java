package com.example.Todo.controller;

import com.example.Todo.dto.tododto;
import com.example.Todo.service.todoservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/todo")
public class todocontroller {
    public todoservice todoservice;
    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public ResponseEntity<tododto>  addtodo(@RequestBody tododto tododto){
        tododto savedtodo=todoservice.addtodo(tododto);
        return  new ResponseEntity<>(savedtodo, HttpStatus.OK);
    }   @PreAuthorize("hasAnyRole('admin','user')")
    @GetMapping("{id}")
public  ResponseEntity<tododto> gettodo(@PathVariable  Long id){
        tododto gettodo=todoservice.gettodo(id);
        return  new ResponseEntity<>(gettodo ,HttpStatus.OK);
}
    @PreAuthorize("hasAnyRole('admin','user')")
@GetMapping
public  ResponseEntity<List<tododto>> getalltodo(){
        List<tododto> todos=todoservice.getalltododto();
        return  ResponseEntity.ok(todos);
}@PreAuthorize("hasRole('admin')")
@PutMapping("{id}")
public    ResponseEntity<tododto> updatedtodo(@RequestBody tododto tododto,@PathVariable("id") Long id){

tododto updatedtodo=todoservice.updatetodo(tododto,id);
return  ResponseEntity.ok(updatedtodo);
}@PreAuthorize("hasRole('admin')")
@DeleteMapping({"{id}"})

public   ResponseEntity<String> deletetodo(@PathVariable("id") Long id){
        todoservice.deletetodo(id);
        return  ResponseEntity.ok("delete done");
}@PreAuthorize("hasAnyRole('admin','user')")
@PatchMapping("{id}/completed")
public ResponseEntity<tododto> completetod(@PathVariable Long id){
        tododto updatedtodo=todoservice.comletetodo(id);
        return ResponseEntity.ok(updatedtodo);
}@PreAuthorize("hasAnyRole('admin','user')")
@PatchMapping("{id}/incomplete")
    public   ResponseEntity<tododto> incompletetodo(@PathVariable Long id){
        tododto updatedtodo=todoservice.incompletetodo(id);
        return  ResponseEntity.ok(updatedtodo);
}
}
