package com.jesusbeb.springboot.error.springboot_error.services;

import java.util.List;

import com.jesusbeb.springboot.error.springboot_error.models.domain.User;

// Interface para el servicio de usuarios, define los métodos que se implementarán en la clase UserServiceImpl.
public interface UserService {

    List<User> findAll();
    
    User findById(Long id);
    
}
