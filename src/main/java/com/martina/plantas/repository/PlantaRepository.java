package com.martina.plantas.repository;

import com.martina.plantas.entities.Planta;
import com.martina.plantas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Martina
 */
@Repository
public interface PlantaRepository extends JpaRepository<Planta, Integer>{
    
    boolean existsPlantaByNombrePlantaAndUsuarioidUsuario(String nombrePlanta, Usuario usuarioidUsuario);
    
}
