package com.example.Todo.configuration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@EnableMethodSecurity
@Configuration
@AllArgsConstructor
public class springsecuritconfiguration {
    @Autowired
    private  UserDetailsService userDetailsService ;
    @Bean
    public  static PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain  securityFilterChain(HttpSecurity http) throws  Exception{
        http.csrf(csrf->csrf.disable()).authorizeHttpRequests((auth)->{
     //     auth.requestMatchers(HttpMethod.POST, "api/**").hasRole("admin");
       //   auth.requestMatchers(HttpMethod.PUT,"api/**").hasRole("admin");
         // auth.requestMatchers(HttpMethod.DELETE,"api/**").hasRole("admin");
          //auth.requestMatchers(HttpMethod.GET,"api/**").hasAnyRole("admin","user");
        //  auth.requestMatchers(HttpMethod.PATCH,"api/**").hasAnyRole("admin","user");
            auth.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());
        return http.build();
    }
@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return  configuration.getAuthenticationManager();
    }

  /*  @Bean
    public UserDetailsService userDetailsService(){

        UserDetails roman= User.builder().username("roman").password(passwordEncoder().encode("muhammad786")).roles("user").build();
        UserDetails biley=User.builder().username("biley").password(passwordEncoder().encode("muhammad786")).roles("admin").build();
        return  new InMemoryUserDetailsManager(roman,biley);



    }*/

}
