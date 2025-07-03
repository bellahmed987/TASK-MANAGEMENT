package com.example.Todo.repository;

import com.example.Todo.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface userrepo extends JpaRepository<user, Long> {

    Optional<user> findByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<user> findByUsernameOrEmail(String username, String email);
}
