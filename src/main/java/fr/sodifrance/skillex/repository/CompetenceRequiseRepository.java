package fr.sodifrance.skillex.repository;

import fr.sodifrance.skillex.domain.CompetenceRequise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data JPA repository for the CompetenceRequise entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompetenceRequiseRepository extends JpaRepository<CompetenceRequise, Long>, JpaSpecificationExecutor<CompetenceRequise> {
    List<CompetenceRequise> findByEquipeId(long id);

/*    void delete(Long id);*/
}
