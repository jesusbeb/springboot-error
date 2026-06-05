package com.jesusbeb.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.jesusbeb.springboot.error.springboot_error.models.domain.User;

// Interface para el servicio de usuarios, define los métodos que se implementarán en la clase UserServiceImpl.
public interface UserService {

    List<User> findAll();
    
    Optional<User> findById(Long id);

}
