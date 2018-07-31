package fr.sodifrance.skillex.service.mapper;


import fr.sodifrance.skillex.domain.Equipe;
import fr.sodifrance.skillex.service.dto.EquipeDTO;
import fr.sodifrance.skillex.service.dto.EquipeSoftDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper for the entity Competence and its DTO CompetenceDTO.
 */
@Mapper(componentModel = "spring", uses = {CompetenceRequiseMapper.class, CollaborateurMapper.class})
public interface EquipeMapper extends EntityMapper<EquipeDTO, Equipe> {


    EquipeDTO toDto(Equipe equipe);

    @Mapping(target = "competenceRequises", ignore = true)
    @Mapping(target = "collaborateurs", ignore = true)
    @Mapping(target = "pilote", ignore = true)
    Equipe toEntity(EquipeDTO equipeDTO);

/*    EquipeDTO toSoftDto(Equipe e);*/


    List<EquipeSoftDTO> toSoftDto(List<Equipe> e);

}
