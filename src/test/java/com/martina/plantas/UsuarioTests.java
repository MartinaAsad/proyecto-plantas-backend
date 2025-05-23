package com.martina.plantas;

import com.martina.plantas.dto.request.UsuarioDTO;
import com.martina.plantas.entities.Usuario;
import com.martina.plantas.exception.UsuarioErrorException;
import com.martina.plantas.mapper.UsuarioMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@SpringBootTest(classes = {com.martina.plantas.PruebaTechforbApplication})
class UsuarioTests {
    
    @Autowired
    UsuarioMapper usuarioMapper;
    
    String nombre="Martina";
     String apellido="Asad";
     String clave="poiujmkk";
      String mail="mail@gmail.com";

	@Test
	void altaUsuarioExitoso() {
            UsuarioDTO prueba=new UsuarioDTO(nombre, apellido, clave, mail);
            Usuario ingresado=usuarioMapper.MAPPER.aEntidad(prueba);
            
            assertEquals(prueba.getNombre(), ingresado.getNombre());
            assertEquals(prueba.getApellido(), ingresado.getApellido());
            assertEquals(prueba.getClave(), ingresado.getClave());
            assertEquals(prueba.getMail(), ingresado.getMail());
	}
        
        @Test
        void altaUsuarioExistente(){
            UsuarioDTO prueba=new UsuarioDTO(nombre, apellido, clave, mail);
            Usuario ingresado=usuarioMapper.MAPPER.aEntidad(prueba);
            
            assertThrows(UsuarioErrorException.class,()->{
                throwException();
            });
            
        }
        
        private void throwException(){
            throw new UsuarioErrorException("El usuario a ingresar ya existe en el sistema");
        }

}
