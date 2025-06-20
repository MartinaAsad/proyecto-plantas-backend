package com.martina.plantas.controller;

import com.martina.plantas.dto.request.UsuarioDTO;
import com.martina.plantas.dto.request.UsuarioLoginDTO;
import com.martina.plantas.service.AuthServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Martina
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
     @Autowired
     private final AuthServiceImpl authServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(authServiceImpl.login(dto));
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"error\": \"Invalid credentials\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    
    @PostMapping("/users")
    void crearUsuario(@Valid @RequestBody UsuarioDTO u){
        authServiceImpl.crearUsuario(u);
    }
    
}
