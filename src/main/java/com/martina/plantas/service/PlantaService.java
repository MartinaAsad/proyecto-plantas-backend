
package com.martina.plantas.service;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.dto.request.PlantaEdicionDTO;

/**
 *
 * @author Martina
 */
public interface PlantaService {
    
    void crearPlanta (PlantaDTO p);
    void editarPlanta (PlantaEdicionDTO planta, Integer plantaSeleccionada);
    Integer obtenerCantSensores (Integer id);
    Integer obtenerAlertasMedias (Integer id);
    Integer obtenerAlertasRojas (Integer id);
}
