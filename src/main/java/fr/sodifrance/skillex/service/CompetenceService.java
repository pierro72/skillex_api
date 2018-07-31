package fr.sodifrance.skillex.service;

import fr.sodifrance.skillex.domain.Competence;
import fr.sodifrance.skillex.exception.ResourceNotFoundException;
import fr.sodifrance.skillex.repository.CompetenceRepository;
import fr.sodifrance.skillex.service.mapper.CompetenceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Competence.
 */
@Service
public class CompetenceService {

    private final Logger log = LoggerFactory.getLogger(CompetenceService.class);
    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository, CompetenceMapper competenceMapper) {
        this.competenceRepository = competenceRepository;
    }

    /**
     * Save a competence.
     *
     * @param competence the entity to save
     * @return the persisted entity
     */
    public Competence save(Competence competence) {
        log.debug("Request to save Competence : {}", competence);
        return competenceRepository.save(competence);
    }

    /**
     *  Get all the competences.
     *
     *  @return the list of entities
     */
    public List<Competence> findAll() {
        log.debug("Request to get all Competences");
        return competenceRepository.findAll();
    }

    /**
     *  Get one competence by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Competence findOne(Long id) {
        log.debug("Request to get Competence : {}", id);
        Competence competence =  competenceRepository.getOne(id);
        if (competence == null){ throw new ResourceNotFoundException( Competence.class.getSimpleName(), id); }
        return  competence;
    }

    /**
     *  Delete the  competence by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Competence : {}", id);
        Competence competence =  competenceRepository.getOne(id);
        if (competence == null){ throw new ResourceNotFoundException( Competence.class.getSimpleName(), id); }
        competenceRepository.deleteById(id);
    }
}
