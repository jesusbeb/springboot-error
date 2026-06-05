package com.jesusbeb.springboot.error.springboot_error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesusbeb.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.jesusbeb.springboot.error.springboot_error.models.domain.User;
import com.jesusbeb.springboot.error.springboot_error.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String index() {
        //int value = 100 / 0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        
        return "ok 200!!!";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable Long id) {
        // orElseThrow se utiliza para lanzar una excepcion personalizada cuando el usuario no se encuentra en la BD en este caso se lanza una excepcion de tipo UserNotFoundException con un mensaje personalizado.
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException("El usuario no existe!!!"));
  
        System.out.println(user.getName());
        return user;
    }

}
