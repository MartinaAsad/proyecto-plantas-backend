package com.martina.plantas.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Martina
 */
@NotNull
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLoginDTO {
    
    private String mail;
    private String clave;
}
