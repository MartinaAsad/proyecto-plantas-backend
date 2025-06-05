package com.martina.plantas.exception;

/**
 *
 * @author Martina
 */
public class PlantaExistingException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public PlantaExistingException(String message) {
        super(message);
    }
    
}
