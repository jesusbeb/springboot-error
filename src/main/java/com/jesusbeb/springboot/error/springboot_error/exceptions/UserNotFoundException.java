package com.jesusbeb.springboot.error.springboot_error.exceptions;


// UserNotFoundException es una excepcion personalizada que se lanza cuando se intenta acceder a un usuario que no existe en la base de datos. 
// Esta excepcion extiende de RuntimeException, lo que significa que es una excepcion no verificada, y no es necesario declararla en el método que la lanza.
public class UserNotFoundException extends RuntimeException{

    // El constructor de la clase recibe un mensaje que se le pasa al constructor de la clase padre RuntimeException, para que se pueda mostrar el mensaje de error cuando se lance la excepcion.
    public UserNotFoundException(String message) {
        super(message);
    }
    
}
