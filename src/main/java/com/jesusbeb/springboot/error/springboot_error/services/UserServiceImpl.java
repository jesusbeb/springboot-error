package com.jesusbeb.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jesusbeb.springboot.error.springboot_error.models.domain.User;

// Clase que implementa la interfaz UserService, proporciona la lógica para manejar los usuarios.
@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    // En el constructor se inicializa la lista de usuarios con algunos datos de ejemplo para simular una BD.
    public UserServiceImpl() {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Pepe", "Gonzalez"));
        users.add(new User(2L, "Andres", "Mena"));
        users.add(new User(3L, "Maria", "Perez"));
        users.add(new User(4L, "Josefa", "Ramirez"));
        users.add(new User(5L, "Ale", "Gutierrez"));
    }


    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = null;
        for (User u : users) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }
        return Optional.ofNullable(user); // ofNullable se utiliza para crear un Optional a partir de un valor que puede ser null, en este caso se retorna el usuario encontrado o null si no se encuentra.
    }


}
