package com.jesusbeb.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jesusbeb.springboot.error.springboot_error.models.domain.User;


// Clase de configuración de la aplicación, se utiliza para definir beans que se utilizarán en la aplicación, en este caso se define un bean de tipo List<User> que contiene una lista de usuarios para simular una BD.
@Configuration
public class AppConfig {

    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Pepe", "Gonzalez"));
        users.add(new User(2L, "Andres", "Mena"));
        users.add(new User(3L, "Maria", "Perez"));
        users.add(new User(4L, "Josefa", "Ramirez"));
        users.add(new User(5L, "Ale", "Gutierrez"));
        return users;
    }

}
