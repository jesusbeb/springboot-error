package com.jesusbeb.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

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

        // @ResponseStatus se le indica el estado HTTP que se va a devolver al cliente: INTERNAL_SERVER_ERROR (500). Esto porque no se indica el estado HTTP en el ResponseEntity, sino que se indica en la anotación.
        // @ResponseBody es una anotación que se le indica que el valor que se va a devolver al cliente es un objeto JSON, cuya informacion en este caso esta dentro de un Map<String, Object>.
        @ExceptionHandler(NumberFormatException.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ResponseBody
        public Map<String, Object> numberFormatException(Exception ex) {
            
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("date", new Date());
            errorMap.put("error", "Formato de numero no valido!!!");
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
