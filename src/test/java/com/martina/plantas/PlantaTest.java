
package com.martina.plantas;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.entities.Paises;
import com.martina.plantas.entities.Planta;
import com.martina.plantas.entities.Usuario;
import com.martina.plantas.mapper.PlantasMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Martina
 */
public class PlantaTest {
    
    @Autowired
    PlantasMapper plantasMapper;
    
     String nombrePlanta="Quilmes";
     Usuario dueno=new Usuario("Juan", "Perez", "mail@gmail.com", "clave1234");
     Paises pais= new Paises();
    
     @Test
     void altaPlantaExitoso(){
         PlantaDTO prueba=new PlantaDTO(nombrePlanta, 1, 1);
         Planta ingresado=plantasMapper.MAPPER.aEntidad(prueba);
         
         assertEquals(prueba.getNombrePlanta(), ingresado.getNombrePlanta());
            assertEquals(prueba.getDueno().toString(), ingresado.getUsuarioidUsuario().toString());
            //assertEquals(prueba.getPais().toString(), ingresado.getPais().toString());
     }
}
