package fr.sodifrance.skillex.service;

import fr.sodifrance.skillex.domain.CompetenceAcquise;
import fr.sodifrance.skillex.exception.ResourceNotFoundException;
import fr.sodifrance.skillex.repository.CompetenceAcquiseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing CompetenceAcquise.
 */
@Service
public class CompetenceAcquiseService {

    private final Logger log = LoggerFactory.getLogger(CompetenceAcquiseService.class);
    private final CompetenceAcquiseRepository competenceAcquiseRepository;

    public CompetenceAcquiseService(CompetenceAcquiseRepository competenceAcquiseRepository) {
        this.competenceAcquiseRepository = competenceAcquiseRepository;
    }

    /**
     * Save a competenceAcquise.
     *
     * @param competenceAcquise the entity to save
     * @return the persisted entity
     */
    public CompetenceAcquise save(CompetenceAcquise competenceAcquise) {
        log.debug("Request to save CompetenceAcquise : {}", competenceAcquise);
        competenceAcquise = competenceAcquiseRepository.save(competenceAcquise);
        return competenceAcquise;
    }

    /**
     *  Get all the competenceAcquises.
     *
     *  @return the list of entities
     */
    public List<CompetenceAcquise> findAll() {
        log.debug("Request to get all CompetenceAcquises");
        return competenceAcquiseRepository.findAll();
    }

    public List<CompetenceAcquise> findAllByCollaborateurId(long id) {
        log.debug("Request to get all CompetenceAcquises");
        return competenceAcquiseRepository.findByCollaborateurId(id);
    }

    /**
     *  Get one competenceAcquise by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public CompetenceAcquise findOne(Long id) {
        log.debug("Request to get CompetenceAcquise : {}", id);
        CompetenceAcquise competenceAcquise = competenceAcquiseRepository.getOne(id);
        if (competenceAcquise == null){ throw new ResourceNotFoundException( CompetenceAcquise.class.getSimpleName(), id); }
        return competenceAcquise;
    }

    /**
     *  Delete the  competenceAcquise by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete CompetenceAcquise : {}", id);
        competenceAcquiseRepository.deleteById(id);
    }
}
