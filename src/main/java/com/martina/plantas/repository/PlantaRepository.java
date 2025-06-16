package com.martina.plantas.repository;

import com.martina.plantas.dto.response.PlantaResponse;
import com.martina.plantas.entities.Planta;
import com.martina.plantas.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Martina
 */
@Repository
public interface PlantaRepository extends JpaRepository<Planta, Integer>{
    
    boolean existsPlantaByNombrePlantaAndUsuarioidUsuario(String nombrePlanta, Usuario usuarioidUsuario);
    
    @Query("SELECT new com.martina.plantas.dto.response.PlantaResponse (pa.nombrePais, pa.imagen, p.nombrePlanta, " +
"p.cantLecturas, p.alertasMedidas, p.alertasRojas)  FROM Planta p " +
"INNER JOIN Paises pa ON " +
"pa.id=p.pais.id " +
"WHERE p.usuarioidUsuario.idUsuario= :idUsuario")
    Page<PlantaResponse> getAll(Integer idUsuario, Pageable p);
    
    @Query("SELECT sensoresDeshab FROM Planta WHERE usuarioidUsuario= :usuarioidUsuario")
    Integer getSensoresDeshabByUsuarioidUsuario(Usuario usuarioidUsuario);
    
    @Query("SELECT alertasMedidas FROM Planta WHERE usuarioidUsuario= :usuarioidUsuario")
    Integer getAlertasMediasDeshabByUsuarioidUsuario(Usuario usuarioidUsuario);
    
      @Query("SELECT alertasRojas FROM Planta WHERE usuarioidUsuario= :usuarioidUsuario")
    Integer getAlertasRojasByUsuarioidUsuario(Usuario usuarioidUsuario);
    
     @Query("SELECT cantLecturas FROM Planta WHERE usuarioidUsuario= :usuarioidUsuario")
    Integer getLecturasByUsuarioidUsuario(Usuario usuarioidUsuario);
    
    
    
}
