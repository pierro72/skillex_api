package fr.sodifrance.skillex.service.mapper;

import fr.sodifrance.skillex.domain.Collaborateur;
import fr.sodifrance.skillex.service.dto.CollaborateurDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for the entity Competence and its DTO CompetenceDTO.
 */
@Mapper(componentModel = "spring", uses = {CompetenceAcquiseMapper.class})
public interface CollaborateurMapper extends EntityMapper<CollaborateurDTO, Collaborateur> {

    CollaborateurMapper INSTANCE = Mappers.getMapper( CollaborateurMapper.class );

/*    @Mapping(target = "competenceAcquises", ignore = true)*/
    CollaborateurDTO toDto(Collaborateur collaborateur);

    @Mapping(target = "competenceAcquises", ignore = true)
    Collaborateur toEntity(CollaborateurDTO collaborateurDTO);

}
