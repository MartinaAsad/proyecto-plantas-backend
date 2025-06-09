
package com.martina.plantas.dto.request;

import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Martina
 */

public class PlantaDTO implements Serializable {
    
     @Pattern(regexp = "^[a-zA-Z]+$", message = "solo se aceptan letras como nombre de la planta")//solo acepta letras
     @Length(min=3, max=40)
     private String nombrePlanta;
    private Integer dueno;
    private Integer idPais;

    public PlantaDTO(){
        
    }

    public PlantaDTO(String nombrePlanta, Integer dueno, Integer idPais) {
        this.nombrePlanta = nombrePlanta;
        this.dueno = dueno;
        this.idPais = idPais;
    }

    public String getNombrePlanta() {
        return nombrePlanta;
    }

    public void setNombrePlanta(String nombrePlanta) {
        this.nombrePlanta = nombrePlanta;
    }

    public Integer getDueno() {
        return dueno;
    }

    public void setDueno(Integer dueno) {
        this.dueno = dueno;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    
   
    
    
}
