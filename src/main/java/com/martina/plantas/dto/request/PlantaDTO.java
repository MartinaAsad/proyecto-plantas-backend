
package com.martina.plantas.dto.request;

import com.martina.plantas.entities.Paises;
import com.martina.plantas.entities.Usuario;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Martina
 */

public class PlantaDTO {
    
     @Pattern(regexp = "^[a-zA-Z]+$", message = "solo se aceptan letras como nombre de la planta")//solo acepta letras
     @Length(min=3, max=40)
     private String nombrePlanta;
    private Usuario dueno;
    private Paises pais;

    public PlantaDTO(){
        
    }
    public PlantaDTO(String nombrePlanta, Usuario dueno, Paises pais) {
        this.nombrePlanta = nombrePlanta;
        this.dueno = dueno;
        this.pais = pais;
    }
    
    

    public String getNombrePlanta() {
        return nombrePlanta;
    }

    public void setNombrePlanta(String nombrePlanta) {
        this.nombrePlanta = nombrePlanta;
    }

    public Usuario getDueno() {
        return dueno;
    }

    public void setDueno(Usuario dueno) {
        this.dueno = dueno;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }
    
    
}
