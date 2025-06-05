
package com.martina.plantas.service;

import com.martina.plantas.dto.request.PlantaDTO;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martina
 */
@Service
public interface PlantaService {
    
    void crearPlanta (PlantaDTO p);
    
}
