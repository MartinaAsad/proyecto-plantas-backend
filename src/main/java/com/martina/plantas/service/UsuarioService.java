package com.martina.plantas.service;

import com.martina.plantas.dto.request.UsuarioDTO;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martina
 */
@Service
public interface UsuarioService {
    
    void crearUsuario(UsuarioDTO uDto);
}
