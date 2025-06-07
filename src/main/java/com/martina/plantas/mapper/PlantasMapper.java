
package com.martina.plantas.mapper;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.entities.Paises;
import com.martina.plantas.entities.Planta;
import com.martina.plantas.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Martina
 */
@Mapper (componentModel = "spring")
public interface PlantasMapper {
    PlantasMapper MAPPER=Mappers.getMapper(PlantasMapper.class);
    
    @Mapping(source="usuarioidUsuario.idUsuario", target="dueno")
    @Mapping(source="pais.id", target="idPais")
    PlantaDTO aDto(Planta p);
   
    
    @Mapping(target="usuarioidUsuario", expression="java(intAObjeto(dto.getDueno()))")
    @Mapping(target="pais", expression="java(intAPais(dto.getIdPais()))")
    @Mapping(target="idPlanta", ignore=true)
    @Mapping(target="cantLecturas", ignore=true)
    @Mapping(target="alertasMedidas", ignore=true)
    @Mapping(target="alertasRojas", ignore=true)
    @Mapping(target="sensoresDeshab", ignore=true)
    Planta aEntidad (PlantaDTO dto);
    
    //castear int a usuario
        default Usuario intAObjeto (Integer dueno){
        if(dueno==null) return null;
        Usuario u=new Usuario();
        u.setIdUsuario(dueno);
        return u;
        }
        
        default Paises intAPais (Integer dueno){
        if(dueno==null) return null;
        Paises paises=new Paises();
        paises.setId(dueno);
        return paises;
    }
}

