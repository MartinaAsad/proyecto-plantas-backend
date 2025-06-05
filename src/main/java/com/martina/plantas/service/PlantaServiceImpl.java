
package com.martina.plantas.service;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.entities.Planta;
import com.martina.plantas.mapper.PlantasMapper;
import com.martina.plantas.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Martina
 */
public class PlantaServiceImpl implements PlantaService {
    
    @Autowired
    private PlantaRepository plantaRepository;
    
    private final PlantasMapper plantasMapper;
    
    @Autowired
       public PlantaServiceImpl(PlantasMapper plantasMapper) {
        this.plantasMapper = plantasMapper;
    }

    @Override
    public void crearPlanta(PlantaDTO dto) {
        Planta p=plantasMapper.aEntidad(dto);
    }
    
}
