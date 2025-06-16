
package com.martina.plantas.controller;

import com.martina.plantas.dto.request.UsuarioDTO;
import com.martina.plantas.dto.response.InfoPersonalResponse;
import com.martina.plantas.service.PlantaServiceImpl;
import com.martina.plantas.service.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UsuarioController {
    
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;
    
    @Autowired
    private PlantaServiceImpl plantaServiceImpl;
    
    @PostMapping("/users")
    void crearUsuario(@Valid @RequestBody UsuarioDTO u){
        usuarioServiceImpl.crearUsuario(u);
    }
    
    @PatchMapping ("/users/{id}")
    void actualizarUsuario(@PathVariable("id") Integer id, @RequestBody UsuarioDTO u){
        usuarioServiceImpl.actualizarUsuario(id, u);
    }
    
    @GetMapping("/users/{id}/sensors/sum")
    Integer obtenerSumaSensores (@PathVariable("id") Integer id){
        return plantaServiceImpl.obtenerSumaSensores(id);
    }
    
     @GetMapping("/users/{id}/mediumAlerts/sum")
    Integer obtenerAlertasMedias (@PathVariable("id") Integer id){
        return plantaServiceImpl.obtenerSumaAlertasMedias(id);
    }
    
    @GetMapping("/users/{id}/redAlerts/sum")
    Integer obtenerAlertasRojas (@PathVariable("id") Integer id){
        return plantaServiceImpl.obtenerSumaAlertasRojas(id);
    }
    
     @GetMapping("/users/{id}/lectures/sum")
    Integer obtenerLecturas (@PathVariable("id") Integer id){
        return plantaServiceImpl.obtenerSumaCantLecturas(id);
    }
    
    @GetMapping("/users/{id}/personalInfo")
    InfoPersonalResponse obtenerIndo(@PathVariable("id") Integer id){
        return usuarioServiceImpl.obtenerNombreApellido(id);
    }
}
