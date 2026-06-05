package com.jesusbeb.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusbeb.springboot.error.springboot_error.models.domain.User;

// Clase que implementa la interfaz UserService, proporciona la lógica para manejar los usuarios.
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private List<User> users;


    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional< User> findById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
        // for (User u : users) {
        //     if (u.getId().equals(id)) {
        //         user = u;
        //         break;
        //     }
        // }    }
    }
}