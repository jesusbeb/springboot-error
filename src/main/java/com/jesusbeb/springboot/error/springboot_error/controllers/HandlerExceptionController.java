package com.jesusbeb.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.jesusbeb.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.jesusbeb.springboot.error.springboot_error.models.Error;

// @RestControllerAdvice es una anotación que se utiliza para manejar las excepciones de forma global en toda la aplicación, siempre y cuando se indique el tipo de excepción que se va a manejar con la anotación @ExceptionHandler.
@RestControllerAdvice
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

        // @ResponseStatus se le indica el estado HTTP que se va a devolver al cliente: INTERNAL_SERVER_ERROR (500). Esto porque no se indica el estado HTTP en el ResponseEntity, sino que se indica en la anotación.
        // Se utiliza un Map para devolver la información del error, en lugar de un objeto de tipo Error. Esto es para mostrar que se pueden personalizar las respuestas de error de diferentes formas.
        @ExceptionHandler(NumberFormatException.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public Map<String, Object> numberFormatException(Exception ex) {
            
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("date", new Date());
            errorMap.put("error", "Formato de numero no valido!!!");
            errorMap.put("message", ex.getMessage());
            errorMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

            return errorMap;
        }

        // NullPointerException es una excepcion que se lanza cuando se intenta acceder a un objeto que no ha sido inicializado, o que ha sido inicializado con null. 
        // HttpMessageNotWritableException es una excepcion que se lanza cuando se intenta escribir un mensaje HTTP que no se puede escribir, como por ejemplo un usuario que no tiene un rol asignado y se intenta acceder a su rol. 
        // UserNotFoundException es una excepcion personalizada que se lanza cuando se intenta acceder a un usuario que no existe en la base de datos.
        // Al manejar UserNotFoundException, se puede prescindir de manejar NullPointerException, ya que si se lanza una excepcion de tipo NullPointerException, es porque se ha intentado acceder a un usuario que no existe.
        @ExceptionHandler({NullPointerException.class, 
            HttpMessageNotWritableException.class, 
            UserNotFoundException.class})
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public Map<String, Object> userNotFoundException(Exception ex) {
            
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("date", new Date());
            errorMap.put("error", "El usuario o role no existe!!!");
            errorMap.put("message", ex.getMessage());
            errorMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

            return errorMap;
        }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException e) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api rest no encontrado!!!");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value()); // 404

        return ResponseEntity.status(404).body(error);
    }



}
