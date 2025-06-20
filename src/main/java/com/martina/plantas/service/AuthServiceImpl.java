package com.martina.plantas.service;

import com.martina.plantas.dto.request.AuthDTO;
import com.martina.plantas.dto.request.UsuarioDTO;
import com.martina.plantas.dto.request.UsuarioLoginDTO;
import com.martina.plantas.entities.Usuario;
import com.martina.plantas.exception.UsuarioErrorException;
import com.martina.plantas.mapper.UsuarioMapper;
import com.martina.plantas.repository.UsuarioRepository;
import com.martina.plantas.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

 @Service
 @AllArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UsuarioRepository usuarioRepository;
   @Autowired
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final UsuarioMapper usuarioMapper;

    @Override
    public void crearUsuario(UsuarioDTO uDto) {
        Usuario u=usuarioMapper.aEntidad(uDto);
        u.setClave(passwordEncoder.encode(uDto.getClave()));
        u.setRol("comun");
       if(!verificarNulos(uDto)){
         if(usuarioRepository.findByMail(u.getMail()).isPresent()){
           throw new UsuarioErrorException("El usuario a ingresar ya existe en el sistema");
       }else{
             System.out.println("No existe el mail "+uDto.getMail());
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
    public AuthDTO login(UsuarioLoginDTO u) throws Exception {
        try {
            authenticate(u.getMail(), u.getClave());

            Usuario user = usuarioRepository.findByMail(u.getMail())
                    .orElseThrow(() -> new UsuarioErrorException("Usuario no encontrado"));

            String token = jwtUtil.generateToken(user);
            return new AuthDTO(token);
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            System.out.println(e.getMessage());
            throw new BadCredentialsException("Usuario o clave incorrectos");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("error desde aca"+e.getMessage());
        }
    }
    
     private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
