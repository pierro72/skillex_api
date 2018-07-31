package fr.sodifrance.skillex.service;

import fr.sodifrance.skillex.domain.Branche;
import fr.sodifrance.skillex.exception.ResourceNotFoundException;
import fr.sodifrance.skillex.repository.BrancheRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Branche.
 */
@Service
public class BrancheService {

    private final Logger log = LoggerFactory.getLogger(BrancheService.class);
    private final BrancheRepository brancheRepository;


    public BrancheService(BrancheRepository brancheRepository) {
        this.brancheRepository = brancheRepository;
    }

    /**
     * Save a branche.
     *
     * @param branche the entity to save
     * @return the persisted entity
     */
    public Branche save(Branche branche) {
        log.debug("Request to save Branche : {}", branche);
        Branche result = brancheRepository.save(branche);
        return result;
    }

    /**
     *  Get all the branches.
     *
     *  @return the list of entities
     */
    public List<Branche> findAll() {
        log.debug("Request to get all Branches");
        return brancheRepository.findAll();
    }

    /**
     * Return a {@link List} of {%link Branche}
     * @return the matching entities.
     */
    public List<Branche> findAllBrancheParent() {
        log.debug("find branche parents");
        return brancheRepository.findByBrancheParenteOnIsNullByOrderByNomAsc();
    }

    /**
     *  Get one branche by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Branche findOne(Long id) {
        log.debug("Request to get Branche : {}", id);
        Branche branche =  brancheRepository.getOne(id);
        if (branche == null){ throw new ResourceNotFoundException( Branche.class.getSimpleName(), id); }
        return branche;
    }

    /**
     *  Delete the  branche by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id)   {
        log.debug("Request to delete Branche : {}", id);
        Branche branche =  brancheRepository.getOne(id);
        if (branche == null){ throw new ResourceNotFoundException( Branche.class.getSimpleName(), id); }
        brancheRepository.deleteById(id);
    }
}
