package com.example.Todo.service;

import com.example.Todo.dto.logindto;
import com.example.Todo.dto.regesterdto;
import com.example.Todo.entity.role;
import com.example.Todo.entity.user;
import com.example.Todo.exception.todoapiexception;
import com.example.Todo.repository.rolerepo;
import com.example.Todo.repository.userrepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class authserviceimpl  implements   authservice{
    private userrepo userrepo;
    private PasswordEncoder passwordEncoder;
    private rolerepo rolerepo;
    private AuthenticationManager authenticationManager;
    @Override
    public String Regester(regesterdto regesterdto) {
       if(userrepo.existsByEmail(regesterdto.getUsername())){
           throw  new todoapiexception(HttpStatus.BAD_REQUEST,"user already exsist");
       }
       user user=new user();
       user.setUsername(regesterdto.getUsername());
       user.setEmail(regesterdto.getEmail());
       user.setPassword(passwordEncoder.encode(regesterdto.getPassword()));
        Set<role> role=new HashSet<>();
        role userrole=rolerepo.findByName("ROLE_user");
        role.add(userrole);
        user.setRoles(role);
        userrepo.save(user);

        return "regestration sccuessfull";
    }

    @Override
    public String Login(logindto logindto) {
    Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                logindto.getUsernameoremail(),
                logindto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "Login successfull";
    }
}
