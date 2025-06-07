package com.martina.plantas.service;

import com.martina.plantas.dto.request.UsuarioDTO;
import com.martina.plantas.entities.Usuario;
import com.martina.plantas.exception.UsuarioErrorException;
import com.martina.plantas.mapper.UsuarioMapper;
import com.martina.plantas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martina
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    private final UsuarioMapper usuarioMapper;
    
    @Autowired
    public UsuarioServiceImpl(UsuarioMapper usuarioMapper){
        this.usuarioMapper=usuarioMapper;
    }

    @Override
    public void crearUsuario(UsuarioDTO uDto) {
       Usuario u=usuarioMapper.aEntidad(uDto);
       
       if(usuarioRepository.findByMail(u.getMail()).isPresent()){
           throw new UsuarioErrorException("El usuario a ingresar ya existe en el sistema");
       }
       usuarioRepository.save(u);
    }
    
}
