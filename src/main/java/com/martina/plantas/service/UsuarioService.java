package com.martina.plantas.service;

import com.martina.plantas.dto.request.UsuarioDTO;
import com.martina.plantas.dto.response.InfoPersonalResponse;

/**
 *
 * @author Martina
 */

public interface UsuarioService {
    
    void crearUsuario(UsuarioDTO uDto);
    void actualizarUsuario(Integer id,UsuarioDTO uDto);
    InfoPersonalResponse obtenerNombreApellido(Integer id);
}
