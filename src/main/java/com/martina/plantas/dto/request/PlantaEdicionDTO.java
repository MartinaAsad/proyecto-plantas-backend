
package com.martina.plantas.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.io.Serializable;

/**
 *
 * @author Martina
 */
public class PlantaEdicionDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Min(value = 1, message = "1 es el valor minimo aceptado")
    @Max(value = 99999999, message = "99999999 es el valor maximo aceptado")
    private int cantLecturas;
    
    @Min(value = 1, message = "1 es el valor minimo aceptado")
    @Max(value = 99999999, message = "99999999 es el valor maximo aceptado")
    private int alertasMedidas;
    
    @Min(value = 1, message = "1 es el valor minimo aceptado")
    @Max(value = 99999999, message = "99999999 es el valor maximo aceptado")
    private int alertasRojas;
    
    @Min(value = 1, message = "1 es el valor minimo aceptado")
    @Max(value = 99999999, message = "99999999 es el valor maximo aceptado")
    private int sensoresDeshab;

    public PlantaEdicionDTO(int cantLecturas, int alertasMedidas, int alertasRojas, int sensoresDeshab) {
        this.cantLecturas = cantLecturas;
        this.alertasMedidas = alertasMedidas;
        this.alertasRojas = alertasRojas;
        this.sensoresDeshab = sensoresDeshab;
    }

    public int getCantLecturas() {
        return cantLecturas;
    }

    public void setCantLecturas(int cantLecturas) {
        this.cantLecturas = cantLecturas;
    }

    public int getAlertasMedidas() {
        return alertasMedidas;
    }

    public void setAlertasMedidas(int alertasMedidas) {
        this.alertasMedidas = alertasMedidas;
    }

    public int getAlertasRojas() {
        return alertasRojas;
    }

    public void setAlertasRojas(int alertasRojas) {
        this.alertasRojas = alertasRojas;
    }

    public int getSensoresDeshab() {
        return sensoresDeshab;
    }

    public void setSensoresDeshab(int sensoresDeshab) {
        this.sensoresDeshab = sensoresDeshab;
    }
    
    
}
