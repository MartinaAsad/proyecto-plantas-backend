
package com.martina.plantas.dto.request;

import com.martina.plantas.entities.Paises;
import com.martina.plantas.entities.Usuario;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Martina
 */
@Data
public class PlantaDTO {
    
     @Pattern(regexp = "^[a-zA-Z]+$", message = "solo se aceptan letras como nombre de la planta")//solo acepta letras
     @Length(min=3, max=40)
     private String nombrePlanta;
    private Usuario dueno;
    private Paises pais;
}
