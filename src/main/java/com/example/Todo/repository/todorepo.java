package com.example.Todo.repository;

import com.example.Todo.entity.todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface todorepo extends JpaRepository<todo,Long> {
}
