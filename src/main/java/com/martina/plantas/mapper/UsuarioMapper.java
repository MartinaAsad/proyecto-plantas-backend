
package com.martina.plantas.mapper;

import com.martina.plantas.dto.request.UsuarioDTO;
import com.martina.plantas.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Martina
 */
@Mapper (componentModel = "spring")
public interface UsuarioMapper {  
    
    UsuarioMapper MAPPER =Mappers.getMapper(UsuarioMapper.class);
    //en source: atributo en entidad
    //en target: atributo en el dto
    UsuarioDTO aDTO (Usuario entidad);
    
    //ignorar atributos para que no se mapeen
    @Mapping(target="idUsuario", ignore=true)
    Usuario aEntidad (UsuarioDTO dto);
    
}
