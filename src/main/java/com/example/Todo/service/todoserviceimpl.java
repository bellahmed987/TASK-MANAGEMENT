package com.example.Todo.service;

import com.example.Todo.dto.tododto;
import com.example.Todo.entity.todo;
import com.example.Todo.exception.runtimeexception;
import com.example.Todo.repository.todorepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class todoserviceimpl implements todoservice{
    private todorepo topdorepo;
    private ModelMapper modelMapper;
    @Override
    public tododto addtodo(tododto tododto) {
todo todo=modelMapper.map(tododto, todo.class);
todo savedtodo=topdorepo.save(todo);
tododto savedtododto=modelMapper.map(savedtodo,tododto.class);
        return savedtododto;
    }

    @Override
    public tododto gettodo(Long id) {
        todo todo=topdorepo.findById(id)
                .orElseThrow(()-> new runtimeexception("id not found" + id));
        return modelMapper.map(todo,tododto.class);
    }

    @Override
    public List<tododto> getalltododto() {
        List<todo> getalltodo=topdorepo.findAll();
        return getalltodo.stream().map((todo -> modelMapper.map(todo ,tododto.class))).collect(Collectors.toList());
    }

    @Override
    public tododto updatetodo(tododto tododto, Long id) {
        todo todo=topdorepo.findById(id).get();
        todo.setTitle(tododto.getTitle());
        todo.setDescription(tododto.getDescription());
        todo.setCompleted(tododto.isCompleted());
        todo updatedtodo=topdorepo.save(todo);
        return modelMapper.map(updatedtodo,tododto.class);
    }

    @Override
    public void deletetodo(Long id) {
        todo todo=topdorepo.findById(id).get();
        topdorepo.deleteById(id);
    }

    @Override
    public tododto comletetodo(Long id) {
        todo todo=topdorepo.findById(id).get();
        todo.setCompleted(Boolean.TRUE);
        todo updatedtodo=topdorepo.save(todo);
        return modelMapper.map(updatedtodo,tododto.class);
    }

    @Override
    public tododto incompletetodo(Long id) {
        todo todo=topdorepo.findById(id).get();
        todo.setCompleted(Boolean.FALSE);
        todo updatedtodo=topdorepo.save(todo);
        return modelMapper.map(updatedtodo,tododto.class);
    }
}
