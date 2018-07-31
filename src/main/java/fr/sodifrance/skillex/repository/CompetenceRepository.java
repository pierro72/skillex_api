package fr.sodifrance.skillex.repository;

import fr.sodifrance.skillex.domain.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the Competence entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long>, JpaSpecificationExecutor<Competence> {

/*    Competence findOne(Long id);*/

/*    void delete(Long id);*/
}
