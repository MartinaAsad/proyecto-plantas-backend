package com.martina.plantas.handler;

import com.martina.plantas.exception.PlantaExistingException;
import com.martina.plantas.exception.UsuarioErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Martina
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsuarioErrorException.class)
    public ResponseEntity<String>handleUsuarioWithPadreException(UsuarioErrorException uf){
         return new ResponseEntity<>(uf.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(PlantaExistingException.class)
    public ResponseEntity<String>handlePlantaExistingException(PlantaExistingException uf){
         return new ResponseEntity<>(uf.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    
    
}
