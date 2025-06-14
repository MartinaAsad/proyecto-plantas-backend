
package com.martina.plantas.service;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.dto.request.PlantaEdicionDTO;
import com.martina.plantas.dto.response.PaginacionResponse;
import com.martina.plantas.dto.response.PlantaResponse;
import org.springframework.data.domain.Pageable;

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
    Integer obtenerCantLecturas (Integer id);
    PaginacionResponse<PlantaResponse> getAll(Integer idUsuario,Pageable pageable);
}
