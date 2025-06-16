package com.martina.plantas.dto.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Martina
 */
@NotNull
@Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ]+( [a-zA-ZÁÉÍÓÚáéíóúñÑ]+)*$", message = "El nombre y apellido solo puede contener letras y espacios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InfoPersonalResponse {
    private String nombre;
    private String apellido;
    
}
