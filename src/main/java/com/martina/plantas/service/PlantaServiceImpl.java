
package com.martina.plantas.service;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.dto.request.PlantaEdicionDTO;
import com.martina.plantas.dto.response.PaginacionResponse;
import com.martina.plantas.dto.response.PlantaResponse;
import com.martina.plantas.entities.Planta;
import com.martina.plantas.entities.Usuario;
import com.martina.plantas.exception.PlantaExistingException;
import com.martina.plantas.exception.UsuarioErrorException;
import com.martina.plantas.mapper.PlantasMapper;
import com.martina.plantas.repository.PlantaRepository;
import com.martina.plantas.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martina
 */
@Service
public class PlantaServiceImpl implements PlantaService {
    
    @Autowired
    private PlantaRepository plantaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    private final PlantasMapper plantasMapper;
    
    @Autowired
    private EntityManager entityManager;
            
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
         
          if(dto.getIdPais()==null){
            throw new UsuarioErrorException("Por favor asigne un pais a la planta");
        }else{
            nulo=false;
        }
        
        
        return nulo;
    }
    public boolean verificarPlanta(PlantaDTO dto){
     boolean verificar=true;
     Usuario u=usuarioRepository.findById(dto.getDueno()).orElseThrow(()-> new UsuarioErrorException("No existe el dueno"));
        if(plantaRepository.existsPlantaByNombrePlantaAndUsuarioidUsuario(dto.getNombrePlanta(), u)){
            throw new PlantaExistingException("Ya existe la planta "+dto.getNombrePlanta()+" en este usuario.");
        }   else{
            verificar=false;
        }
        return verificar;
    }

    @Override
    public void editarPlanta(PlantaEdicionDTO planta, Integer plantaSeleccionada) {
        Planta p=plantaRepository.findById(plantaSeleccionada).orElseThrow(
                ()-> new PlantaExistingException("No existe la planta seleccionada"));
        
        plantasMapper.updatePlantaFromDto(planta, p);
        plantaRepository.save(p);
        
        
    }

    @Override
    public Integer obtenerSumaSensores(Integer id) {
        StoredProcedureQuery query=entityManager
                .createStoredProcedureQuery("sumaSensoresUsuario")
                .registerStoredProcedureParameter("idUsuario", Integer.class, ParameterMode.IN)
         .registerStoredProcedureParameter("totalSensores", Integer.class, ParameterMode.OUT);
   
        query.setParameter("idUsuario",id);
        query.execute();
        
        return (Integer) query.getOutputParameterValue("totalSensores");
    }

    @Override
    public Integer obtenerSumaAlertasMedias(Integer id) {
         StoredProcedureQuery query=entityManager
                .createStoredProcedureQuery("sumaAlertasMedias")
                .registerStoredProcedureParameter("idUsuario", Integer.class, ParameterMode.IN)
         .registerStoredProcedureParameter("alertasMedias", Integer.class, ParameterMode.OUT);
   
        query.setParameter("idUsuario",id);
        query.execute();  
        return (Integer) query.getOutputParameterValue("alertasMedias");
    }

    @Override
    public Integer obtenerSumaAlertasRojas(Integer id) {
         StoredProcedureQuery query=entityManager
                .createStoredProcedureQuery("sumaAlertasRojas")
                .registerStoredProcedureParameter("idUsuario", Integer.class, ParameterMode.IN)
         .registerStoredProcedureParameter("cantAlertasRojas", Integer.class, ParameterMode.OUT);
   
        query.setParameter("idUsuario",id);
        query.execute();  
        return (Integer) query.getOutputParameterValue("cantAlertasRojas");
    }

    @Override
    public Integer obtenerSumaCantLecturas(Integer id) {
        StoredProcedureQuery query=entityManager
                .createStoredProcedureQuery("sumarCantLecturas")
                .registerStoredProcedureParameter("idUsuario", Integer.class, ParameterMode.IN)
         .registerStoredProcedureParameter("total", Integer.class, ParameterMode.OUT);
   
        query.setParameter("idUsuario",id);
        query.execute();  
        return (Integer) query.getOutputParameterValue("total");
    }

    @Override
    public PaginacionResponse<PlantaResponse> getAll(Integer idUsuario,Pageable pageable) {
       Page<PlantaResponse> lista=plantaRepository.getAll(idUsuario,pageable);
       return new PaginacionResponse<>(
               lista.getContent(),
               lista.getNumber(),
               lista.getSize(),
               lista.getTotalElements(),
               lista.getTotalPages(),
               lista.isLast()
       );
    }

    @Override
    public Integer obtenerSensores(Integer id) {
        Usuario u=usuarioRepository.findById(id).orElseThrow(()-> new UsuarioErrorException("No existe el usuario"));
        return plantaRepository.getSensoresDeshabByUsuarioidUsuario(u);
    }

    @Override
    public Integer obtenerAlertasMedias(Integer id) {
        Usuario u=usuarioRepository.findById(id).orElseThrow(()-> new UsuarioErrorException("No existe el usuario"));
        return plantaRepository.getAlertasMediasDeshabByUsuarioidUsuario(u);
    }

    @Override
    public Integer obtenerAlertasRojas(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer obtenerLecturas(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
    
}
