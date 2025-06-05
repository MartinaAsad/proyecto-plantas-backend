
package com.martina.plantas.service;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.entities.Planta;
import com.martina.plantas.exception.PlantaExistingException;
import com.martina.plantas.exception.UsuarioErrorException;
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
        
        if(!(verificarNulos(dto) && verificarPlanta(dto))){
            plantaRepository.save(p);
        }
   
    }
    
    public boolean verificarNulos(PlantaDTO dto){
        boolean nulo=true;
        
        if(dto.getNombrePlanta().isEmpty()){
            throw new UsuarioErrorException("Por favor ingrese el nombre de la planta");
        }else{
            nulo=false;
        }
        
         if(dto.getDueno()==null){
            throw new UsuarioErrorException("Por favor asigne un dueno a la planta");
        }else{
            nulo=false;
        }
         
          if(dto.getPais()==null){
            throw new UsuarioErrorException("Por favor asigne un pais a la planta");
        }else{
            nulo=false;
        }
        
        
        return nulo;
    }
    public boolean verificarPlanta(PlantaDTO dto){
     boolean verificar=true;
        if(plantaRepository.existsPlantaByNombrePlantaAndUsuarioidUsuario(dto.getNombrePlanta(), dto.getDueno())){
            throw new PlantaExistingException("Ya existe la planta "+dto.getNombrePlanta()+" en este usuario.");
        }   else{
            verificar=false;
        }
        return verificar;
    }
    
}
