package fr.sodifrance.skillex.service.mapper;

import fr.sodifrance.skillex.domain.Competence;
import fr.sodifrance.skillex.service.dto.CompetenceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Competence and its DTO CompetenceDTO.
 */
@Mapper(componentModel = "spring", uses = {BrancheMapper.class})
public interface CompetenceMapper extends EntityMapper<CompetenceDTO, Competence> {

    @Mapping(source = "brancheParente.id", target = "brancheParenteId")
    CompetenceDTO toDto(Competence competence);


    @Mapping(source = "brancheParenteId", target = "brancheParente")
    @Mapping(target = "competenceAcquises", ignore = true)
    Competence toEntity(CompetenceDTO competenceDTO);

    default Competence fromId(Long id) {
        if (id == null) {
            return null;
        }
        Competence competence = new Competence();
        competence.setId(id);
        return competence;
    }
}
