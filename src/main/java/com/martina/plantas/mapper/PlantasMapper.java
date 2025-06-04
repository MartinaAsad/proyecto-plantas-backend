
package com.martina.plantas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Martina
 */
@Mapper (componentModel = "spring")
public interface PlantasMapper {
    PlantasMapper MAPPER=Mappers.getMapper(PlantasMapper.class);
    
    
    
}
