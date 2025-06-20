
package com.martina.plantas.service;

import com.martina.plantas.dto.request.AuthDTO;
import com.martina.plantas.dto.request.UsuarioDTO;
import com.martina.plantas.dto.request.UsuarioLoginDTO;

/**
 *
 * @author Martina
 */
public interface AuthService {
    void crearUsuario(UsuarioDTO uDto);
    AuthDTO login (UsuarioLoginDTO u) throws Exception;
    
}
