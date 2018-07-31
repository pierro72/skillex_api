package fr.sodifrance.skillex.service.mapper;

import fr.sodifrance.skillex.domain.CompetenceRequise;
import fr.sodifrance.skillex.service.dto.CompetenceRequiseDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity CompetenceRequise and its DTO CompetenceRequiseDTO.
 */
@Mapper(componentModel = "spring", uses = {CompetenceMapper.class})
public interface CompetenceRequiseMapper extends EntityMapper<CompetenceRequiseDTO, CompetenceRequise> {


    CompetenceRequiseDTO toDto(CompetenceRequise competenceRequise);

/*    @Mapping(target = "competence", ignore = true)*/
    CompetenceRequise toEntity(CompetenceRequiseDTO competenceRequiseDTO);

    default CompetenceRequise fromId(Long id) {
        if (id == null) {
            return null;
        }
        CompetenceRequise competenceRequise = new CompetenceRequise();
        competenceRequise.setId(id);
        return competenceRequise;
    }
}
