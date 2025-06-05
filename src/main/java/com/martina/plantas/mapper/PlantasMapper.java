
package com.martina.plantas.mapper;

import com.martina.plantas.dto.request.PlantaDTO;
import com.martina.plantas.entities.Planta;
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
    
    @Mapping(source="usuarioidUsuario", target="dueno")
    PlantaDTO aDto(Planta p);
    
    @Mapping(source="dueno", target="usuarioidUsuario")
    @Mapping(target="idPlanta", ignore=true)
    @Mapping(target="cantLecturas", ignore=true)
    @Mapping(target="alertasMedidas", ignore=true)
    @Mapping(target="alertasRojas", ignore=true)
    @Mapping(target="sensoresDeshab", ignore=true)
    Planta aEntidad (PlantaDTO dto);
}
