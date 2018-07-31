package fr.sodifrance.skillex.service.mapper;

import fr.sodifrance.skillex.domain.Branche;
import fr.sodifrance.skillex.service.dto.BrancheDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Branche and its DTO BrancheDTO.
 */
@Mapper(componentModel = "spring", uses = {CompetenceMapper.class})
public interface BrancheMapper extends EntityMapper<BrancheDTO, Branche> {



    //Creation DTO complete
    //TODO Can't map property Competences to CompetenceDTO, Consider to declare/implement a mapping method: map
    @Mapping(source = "brancheParente.id", target = "brancheParenteId")
    @Mapping(source = "competences", target = "competences")
    BrancheDTO toDto(Branche branche);

    //Creation entité depuis DTO
    @Mapping(source = "brancheParenteId", target = "brancheParente")
    @Mapping(target = "competences", ignore = true)
    @Mapping(target = "sousBranches", ignore = true)
    Branche toEntity(BrancheDTO brancheDTO);

/*    CompetenceDTO toDto(Competence competence);

    Competence toEntity(CompetenceDTO competenceDTO);*/

    default Branche fromId(Long id) {
        if (id == null) {
            return null;
        }
        Branche branche = new Branche();
        branche.setId(id);
        return branche;
    }
}
