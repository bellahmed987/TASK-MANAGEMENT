package com.example.Todo.repository;

import com.example.Todo.entity.role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface rolerepo extends JpaRepository<role ,Long> {
    role findByName(String name);
}
