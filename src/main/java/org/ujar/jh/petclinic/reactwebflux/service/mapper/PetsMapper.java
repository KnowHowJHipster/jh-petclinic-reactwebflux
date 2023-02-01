package org.ujar.jh.petclinic.reactwebflux.service.mapper;

import org.mapstruct.*;
import org.ujar.jh.petclinic.reactwebflux.domain.Owners;
import org.ujar.jh.petclinic.reactwebflux.domain.Pets;
import org.ujar.jh.petclinic.reactwebflux.domain.Types;
import org.ujar.jh.petclinic.reactwebflux.service.dto.OwnersDTO;
import org.ujar.jh.petclinic.reactwebflux.service.dto.PetsDTO;
import org.ujar.jh.petclinic.reactwebflux.service.dto.TypesDTO;

/**
 * Mapper for the entity {@link Pets} and its DTO {@link PetsDTO}.
 */
@Mapper(componentModel = "spring")
public interface PetsMapper extends EntityMapper<PetsDTO, Pets> {
    @Mapping(target = "type", source = "type", qualifiedByName = "typesId")
    @Mapping(target = "owner", source = "owner", qualifiedByName = "ownersId")
    PetsDTO toDto(Pets s);

    @Named("typesId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TypesDTO toDtoTypesId(Types types);

    @Named("ownersId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    OwnersDTO toDtoOwnersId(Owners owners);
}
