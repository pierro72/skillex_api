package fr.sodifrance.skillex.controller;

import fr.sodifrance.skillex.domain.Competence;
import fr.sodifrance.skillex.service.CompetenceService;
import fr.sodifrance.skillex.service.dto.CompetenceDTO;
import fr.sodifrance.skillex.service.mapper.CompetenceMapper;
import fr.sodifrance.skillex.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing Competence.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class CompetenceResource {

    private final Logger log = LoggerFactory.getLogger(CompetenceResource.class);
    private static final String ENTITY_NAME = "competence";
    private final CompetenceService competenceService;
    private final CompetenceMapper mapper;

    public CompetenceResource(CompetenceService competenceService,  CompetenceMapper mapper) {
        this.competenceService = competenceService;
        this.mapper = mapper;
    }

    /**
     * POST  /competences : Create a new competence.
     *
     * @param competenceDTO the competenceDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new competenceDTO, or with status 400 (Bad Request) if the competence has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/competences")
    public ResponseEntity<CompetenceDTO> createCompetence(@Valid @RequestBody CompetenceDTO competenceDTO) throws URISyntaxException {
        log.debug("REST request to save Competence : {}", competenceDTO);
        Competence competence  = competenceService.save( mapper.toEntity(competenceDTO) );
        return ResponseEntity.created(new URI("/api/competences/" + competence.getId()))
            .headers(HeaderUtil.ajouterAlert(ENTITY_NAME, competence.getId().toString()))
            .body(mapper.toDto(competence));
    }

    /**
     * PUT  /competences : Updates an existing competence.
     *
     * @param competenceDTO the competenceDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated competenceDTO,
     * or with status 400 (Bad Request) if the competenceDTO is not valid,
     * or with status 500 (Internal Server Error) if the competenceDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/competences")
    public ResponseEntity<CompetenceDTO> updateCompetence(@Valid @RequestBody CompetenceDTO competenceDTO) throws URISyntaxException {
        log.debug("REST request to update Competence : {}", competenceDTO);
        if (competenceDTO.getId() == null) { return createCompetence(competenceDTO); }
        Competence competence  = competenceService.save( mapper.toEntity(competenceDTO) );
        return ResponseEntity.ok()
            .headers(HeaderUtil.editerAlert(ENTITY_NAME, competence.getId().toString()))
            .body( mapper.toDto(competence));
    }

    /**
     * GET  /competences : get all the competences.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of competences in body
     */
    @GetMapping("/competences")
    public ResponseEntity<List<CompetenceDTO>> getAllCompetences( ) {
        log.debug("REST request to get Competences" );
        List<Competence> entityList = competenceService.findAll();
        return ResponseEntity.ok().body(mapper.toDto(entityList));
    }

    /**
     * GET  /competences/:id : get the "id" competence.
     *
     * @param id the id of the competenceDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the competenceDTO, or with status 404 (Not Found)
     */
    @GetMapping("/competences/{id}")
    public ResponseEntity<CompetenceDTO> getCompetence(@PathVariable Long id) {
        log.debug("REST request to get Competence : {}", id);
        Competence competence = competenceService.findOne(id);
        return new ResponseEntity<>( mapper.toDto(competence), HttpStatus.OK);
    }

    /**
     * DELETE  /competences/:id : delete the "id" competence.
     *
     * @param id the id of the competenceDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/competences/{id}")
    public ResponseEntity<Void> deleteCompetence(@PathVariable Long id) {
        log.debug("REST request to delete Competence : {}", id);
        competenceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.supprimerAlert(ENTITY_NAME, id.toString())).build();
    }
}
