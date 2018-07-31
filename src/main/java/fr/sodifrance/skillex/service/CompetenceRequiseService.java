package fr.sodifrance.skillex.service;

import fr.sodifrance.skillex.domain.CompetenceRequise;
import fr.sodifrance.skillex.repository.CompetenceRequiseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;


/**
 * Service Implementation for managing CompetenceRequise.
 */
@Service
public class CompetenceRequiseService {

    private final Logger log = LoggerFactory.getLogger(CompetenceRequiseService.class);
    private final CompetenceRequiseRepository competenceRequiseRepository;


    public CompetenceRequiseService(CompetenceRequiseRepository competenceRequiseRepository) {
        this.competenceRequiseRepository = competenceRequiseRepository;
    }

    /**
     * Save a competenceRequise.
     *
     * @param competenceRequise the entity to save
     * @return the persisted entity
     */
    public CompetenceRequise save(CompetenceRequise competenceRequise) {
        log.debug("Request to save CompetenceRequise : {}", competenceRequise);
        competenceRequise = competenceRequiseRepository.save(competenceRequise);
        return competenceRequise;
    }

    /**
     *  Get all the competenceRequises.
     *
     *  @return the list of entities
     */
    public List<CompetenceRequise> findAll() {
        log.debug("Request to get all CompetenceRequises");
        return competenceRequiseRepository.findAll();
    }

    public List<CompetenceRequise> findAllByEquipeId(long id) {
        log.debug("Request to get all CompetenceAcquises");
        return competenceRequiseRepository.findByEquipeId(id);
    }

    /**
     *  Get one competenceRequise by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public CompetenceRequise findOne(Long id) {
        log.debug("Request to get CompetenceRequise : {}", id);
        return competenceRequiseRepository.getOne(id);
    }

    /**
     *  Delete the  competenceRequise by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete CompetenceRequise : {}", id);
        competenceRequiseRepository.deleteById(id);
    }
}
