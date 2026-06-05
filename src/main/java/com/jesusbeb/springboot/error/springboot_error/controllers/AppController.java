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
        User user = userService.findById(id);
        // Si el usuario no existe, se lanza una excepcion personalizada UserNotFoundException y se envia el mensaje de error.
        if (user == null) {
            throw new UserNotFoundException("El usuario no existe!!!");
        }
        System.out.println(user.getName());
        return user;
    }

}
