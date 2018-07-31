package fr.sodifrance.skillex.service.mapper;

import fr.sodifrance.skillex.domain.CompetenceAcquise;
import fr.sodifrance.skillex.service.dto.CompetenceAcquiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for the entity CompetenceAcquise and its DTO CompetenceAcquiseDTO.
 */
@Mapper(componentModel = "spring", uses = {CompetenceMapper.class})
public interface CompetenceAcquiseMapper extends EntityMapper<CompetenceAcquiseDTO, CompetenceAcquise> {

    CompetenceAcquiseMapper INSTANCE = Mappers.getMapper( CompetenceAcquiseMapper.class );

/*    @Mapping(source = "competence.id", target = "competenceId")*/
    CompetenceAcquiseDTO toDto(CompetenceAcquise competenceAcquise);

/*    @Mapping(target = "competence", ignore = true)*/
    CompetenceAcquise toEntity(CompetenceAcquiseDTO competenceAcquiseDTO);

    default CompetenceAcquise fromId(Long id) {
        if (id == null) {
            return null;
        }
        CompetenceAcquise competenceAcquise = new CompetenceAcquise();
        competenceAcquise.setId(id);
        return competenceAcquise;
    }
}
