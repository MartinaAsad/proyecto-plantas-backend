
package com.martina.plantas.controller;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.dto.request.PlantaEdicionDTO;
import com.martina.plantas.dto.response.PaginacionResponse;
import com.martina.plantas.dto.response.PlantaResponse;
import com.martina.plantas.service.PlantaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/plants/{id}")
    PaginacionResponse<PlantaResponse> obtenerPlantas(@PathVariable("id") Integer id, Pageable p){
     return plantaServiceImpl.getAll(id, p);
    }
    
    @GetMapping("/plants/{id}/sensors")
    Integer obtenerSensores(@PathVariable("id") Integer id){
     return plantaServiceImpl.obtenerSensores(id);
    }
    
     @GetMapping("/plants/{id}/mediumAlerts")
    Integer obtenerAlertasMedias(@PathVariable("id") Integer id){
     return plantaServiceImpl.obtenerAlertasMedias(id);
    }
    
    @GetMapping("/plants/{id}/redAlerts")
    Integer obtenerAlertasRojas(@PathVariable("id") Integer id){
     return plantaServiceImpl.obtenerAlertasRojas(id);
    }
    
    
}
