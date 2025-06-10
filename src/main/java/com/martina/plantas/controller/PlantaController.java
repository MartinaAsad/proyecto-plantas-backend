
package com.martina.plantas.controller;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.dto.request.PlantaEdicionDTO;
import com.martina.plantas.service.PlantaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    void crearPlanta(@Valid @RequestBody PlantaDTO u){
        plantaServiceImpl.crearPlanta(u);
    }
    
    @PatchMapping("/plants/{id}")
    void editarPlanta(@PathVariable("id") Integer id,@Valid @RequestBody PlantaEdicionDTO p){
        plantaServiceImpl.editarPlanta(p, id);
    }
    
}
