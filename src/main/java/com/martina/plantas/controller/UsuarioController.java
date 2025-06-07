
package com.martina.plantas.controller;

import com.martina.plantas.dto.request.UsuarioDTO;
import com.martina.plantas.service.UsuarioServiceImpl;
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
public class UsuarioController {
    
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;
    
    @PostMapping("/users")
    void crearUsuario(@Valid @RequestBody UsuarioDTO u){
        usuarioServiceImpl.crearUsuario(u);
    }
    
    @PatchMapping ("/users/{id}")
    void actualizarUsuario(@PathVariable("id") Integer id, @RequestBody UsuarioDTO u){
        usuarioServiceImpl.actualizarUsuario(id, u);
        
    }
}
