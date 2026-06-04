package com.jesusbeb.springboot.error.springboot_error.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice es un controlador que no esta mapeado a una ruta, sino que se encarga de manejar las excepciones que ocurren en los controladores de la aplicación.
@ControllerAdvice
public class HandlerExceptionController {

    // @ExceptionHandler es una anotación que se le indica el tipo de excepción que se va a manejar
    // El metodo devuelve un ResponseEntity que va en el cuerpo el mensaje de error. Se usa ? para indicar que el tipo de dato es generico, ya que puede ser un String, un objeto, etc.
    // Exception ex es el objeto que contiene la información de la excepción que se ha lanzado.
    // internalServerError() es un metodo de ResponseEntity que indica que el error es un error interno del servidor (500). body() es un metodo que se usa para indicar el cuerpo de la respuesta, en este caso el mensaje de error.
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> divisionByZero(Exception ex) {

        return ResponseEntity.internalServerError().body("error 500!!!");
    }

}
