
package com.martina.plantas.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.io.Serializable;

/**
 *
 * @author Martina
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlantaEdicionDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Min(value = 1, message = "1 es el valor minimo aceptado")
    @Max(value = 9999, message = "9999 es el valor maximo aceptado")
    private Integer cantLecturas;
    
    @Min(value = 1, message = "1 es el valor minimo aceptado")
    @Max(value = 99999, message = "9999 es el valor maximo aceptado")
    private Integer alertasMedidas;
    
    @Min(value = 1, message = "1 es el valor minimo aceptado")
    @Max(value = 9999, message = "9999 es el valor maximo aceptado")
    private Integer alertasRojas;
    
    @Min(value = 1, message = "1 es el valor minimo aceptado")
    @Max(value = 9999, message = "9999 es el valor maximo aceptado")
    private Integer sensoresDeshab;

    public PlantaEdicionDTO(Integer cantLecturas, Integer alertasMedidas, Integer alertasRojas, Integer sensoresDeshab) {
        this.cantLecturas = cantLecturas;
        this.alertasMedidas = alertasMedidas;
        this.alertasRojas = alertasRojas;
        this.sensoresDeshab = sensoresDeshab;
    }

    public Integer getCantLecturas() {
        return cantLecturas;
    }

    public void setCantLecturas(Integer cantLecturas) {
        this.cantLecturas = cantLecturas;
    }

    public Integer getAlertasMedidas() {
        return alertasMedidas;
    }

    public void setAlertasMedidas(Integer alertasMedidas) {
        this.alertasMedidas = alertasMedidas;
    }

    public Integer getAlertasRojas() {
        return alertasRojas;
    }

    public void setAlertasRojas(Integer alertasRojas) {
        this.alertasRojas = alertasRojas;
    }

    public Integer getSensoresDeshab() {
        return sensoresDeshab;
    }

    public void setSensoresDeshab(Integer sensoresDeshab) {
        this.sensoresDeshab = sensoresDeshab;
    }

    
    
}
