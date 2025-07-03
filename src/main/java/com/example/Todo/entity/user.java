package com.example.Todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false ,unique = true)
    private  String username;
    @Column(nullable = false ,unique = true)
    private  String email;
    @Column(nullable = false )
    private  String password;
@ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
@JoinTable(name = "user_roles",
joinColumns = @JoinColumn(name = "userid" ,referencedColumnName = "id"),
    inverseJoinColumns=@JoinColumn(name = "role_id" ,referencedColumnName = "id"))
    private Set<role> roles;
}
