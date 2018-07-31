package fr.sodifrance.skillex.repository;


import fr.sodifrance.skillex.domain.Branche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data JPA repository for the Branche entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BrancheRepository extends JpaRepository<Branche, Long>, JpaSpecificationExecutor<Branche> {


    @Query("select b from Branche b where b.brancheParente IS NULL")
    List<Branche> findByBrancheParenteOnIsNullByOrderByNomAsc();

/*    Branche findOne(Long id);*/

/*    void delete(Long id);*/
}
