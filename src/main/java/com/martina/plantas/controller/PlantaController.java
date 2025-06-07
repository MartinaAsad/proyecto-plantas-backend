
package com.martina.plantas.controller;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.service.PlantaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Martina
 */
@RestController
public class PlantaController {
    
    @Autowired
    private PlantaServiceImpl plantaServiceImpl;
    
    @PostMapping("/plants")
    void crearUsuario(@Valid @RequestBody PlantaDTO u){
        plantaServiceImpl.crearPlanta(u);
    }
    
}
