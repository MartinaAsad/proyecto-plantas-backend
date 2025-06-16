package com.martina.plantas.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



/**
 *
 * @author Martina
 */
@NotNull
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class PlantaResponse {
     private String nombrePais;
     private String imagen;
     private String nombrePlanta;
     private Integer cantLecturas;
     private Integer alertasRojas;
     private Integer sensoresDeshab;
     
     
     
}
