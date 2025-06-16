package com.martina.plantas.service;

import com.martina.plantas.dto.request.UsuarioDTO;
import com.martina.plantas.dto.response.InfoPersonalResponse;
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
       
       if(!verificarNulos(uDto)){
         if(usuarioRepository.findByMail(u.getMail()).isPresent()){
           throw new UsuarioErrorException("El usuario a ingresar ya existe en el sistema");
       }   
       }
       usuarioRepository.save(u);
    }
    
    public boolean verificarNulos (UsuarioDTO dto){
        boolean verificar=false;
        if(dto.getNombre().isEmpty() || dto.getApellido().isEmpty() || dto.getClave().isEmpty() || dto.getMail().isEmpty()){
            throw new UsuarioErrorException("Por favor, complete el campo vacio");
        }else{
            verificar=true;
        }
        return verificar;
    }
    
    @Override
    public void actualizarUsuario(Integer id, UsuarioDTO uDto) {
        Usuario u=usuarioRepository.findById(id).orElseThrow(()-> new UsuarioErrorException("No existe el usuario seleccionado"));
        
        //SOLO si se ingreso un mail diferente, hacer esta validacion
        if(uDto.getMail()!=null && !uDto.getMail().equals(u.getMail())){
            if(usuarioRepository.existsByMail(uDto.getMail())){
                throw new UsuarioErrorException("El mail que desea modificar ya existe");
            }
        }
        usuarioMapper.updateUsuarioFromDto(uDto, u);
         usuarioRepository.save(u);
    }

    @Override
    public InfoPersonalResponse obtenerNombreApellido(Integer id) {
        return usuarioRepository.obtenerInfoPersonal(id);
    }
}
