
package com.martina.plantas.dto.request;

import lombok.Data;

/**
 *
 * @author Martina
 */
@Data
public class PlantaDTO {
     private String nombrePlanta;
    private Integer cantLecturas;
    private Integer alertasMedidas;
    private Integer alertasRojas;
    private Integer sensoresDeshab;
    private Integer dueno;
}
