package com.jesusbeb.springboot.error.springboot_error.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jesusbeb.springboot.error.springboot_error.models.Error;

// @ControllerAdvice es un controlador que no esta mapeado a una ruta, sino que se encarga de manejar las excepciones que ocurren en los controladores de la aplicación.
@ControllerAdvice
public class HandlerExceptionController {

    // @ExceptionHandler es una anotación que se le indica el tipo de excepción que se va a manejar
    // El metodo devuelve un ResponseEntity de tipo Error, que es un objeto que contiene la información del error que se ha producido.
    // Exception ex es el parametro que recibe el metodo, el cual es un objeto de tipo Exception que contiene la información de la excepción que se ha lanzado.
    // Creamos una instancia de la clase Error, que es la que personaliza la respuesta de error que se va a enviar al cliente.
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Division por cero!!!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.internalServerError().body(error);
    }

}
