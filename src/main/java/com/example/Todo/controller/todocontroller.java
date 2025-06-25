package com.example.Todo.controller;

import com.example.Todo.dto.tododto;
import com.example.Todo.service.todoservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/todo")
public class todocontroller {
    private todoservice todoservice;
    @PostMapping
    private ResponseEntity<tododto>  addtodo(@RequestBody tododto tododto){
        tododto savedtodo=todoservice.addtodo(tododto);
        return  new ResponseEntity<>(savedtodo, HttpStatus.OK);
    }
    @GetMapping("{id}")
private  ResponseEntity<tododto> gettodo(@PathVariable  Long id){
        tododto gettodo=todoservice.gettodo(id);
        return  new ResponseEntity<>(gettodo ,HttpStatus.OK);
}
@GetMapping
private  ResponseEntity<List<tododto>> getalltodo(){
        List<tododto> todos=todoservice.getalltododto();
        return  ResponseEntity.ok(todos);
}
@PutMapping("{id}")
private   ResponseEntity<tododto> updatedtodo(@RequestBody tododto tododto,@PathVariable("id") Long id){

tododto updatedtodo=todoservice.updatetodo(tododto,id);
return  ResponseEntity.ok(updatedtodo);
}
@DeleteMapping({"{id}"})
private  ResponseEntity<String> deletetodo(@PathVariable("id") Long id){
        todoservice.deletetodo(id);
        return  ResponseEntity.ok("delete done");
}
@PatchMapping("{id}/completed")
private  ResponseEntity<tododto> completetod(@PathVariable Long id){
        tododto updatedtodo=todoservice.comletetodo(id);
        return ResponseEntity.ok(updatedtodo);
}
@PatchMapping("{id}/incomplete")
private  ResponseEntity<tododto> incompletetodo(@PathVariable Long id){
        tododto updatedtodo=todoservice.incompletetodo(id);
        return  ResponseEntity.ok(updatedtodo);
}
}
