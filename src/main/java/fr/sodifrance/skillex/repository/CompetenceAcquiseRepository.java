package fr.sodifrance.skillex.repository;


import fr.sodifrance.skillex.domain.CompetenceAcquise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data JPA repository for the CompetenceAcquise entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompetenceAcquiseRepository extends JpaRepository<CompetenceAcquise, Long>, JpaSpecificationExecutor<CompetenceAcquise> {
    List<CompetenceAcquise> findByCollaborateurId(long id);

/*    CompetenceAcquise findOne(Long id);*/

/*    void delete(Long id);*/
}
