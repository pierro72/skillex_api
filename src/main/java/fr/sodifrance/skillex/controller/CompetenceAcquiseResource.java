package fr.sodifrance.skillex.controller;

import fr.sodifrance.skillex.domain.CompetenceAcquise;
import fr.sodifrance.skillex.service.CompetenceAcquiseService;
import fr.sodifrance.skillex.service.dto.CompetenceAcquiseDTO;
import fr.sodifrance.skillex.service.mapper.CompetenceAcquiseMapper;
import fr.sodifrance.skillex.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for managing CompetenceAcquise.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class CompetenceAcquiseResource {

    private final Logger log = LoggerFactory.getLogger(CompetenceAcquiseResource.class);
    private static final String ENTITY_NAME = "competenceAcquise";
    private final CompetenceAcquiseService competenceAcquiseService;
    private final CompetenceAcquiseMapper mapper;


    public CompetenceAcquiseResource( CompetenceAcquiseService competenceAcquiseService,
                                      CompetenceAcquiseMapper mapper) {
        this.competenceAcquiseService = competenceAcquiseService;
        this.mapper = mapper;

    }

    /**
     * POST  /competence-acquises : Create a new competenceAcquise.
     *
     * @param entityDTO the competenceAcquiseDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new competenceAcquiseDTO, or with status 400 (Bad Request) if the competenceAcquise has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/collaborateur/{id}/competence-acquises")
    public ResponseEntity<CompetenceAcquiseDTO> createCompetenceAcquise(
            @PathVariable Long id,
            @Valid @RequestBody CompetenceAcquiseDTO entityDTO) throws URISyntaxException {
        log.debug("REST request to save CompetenceAcquise : {}", entityDTO);
        CompetenceAcquise result = competenceAcquiseService.save( mapper.toEntity(entityDTO) );
        return ResponseEntity.created( new URI("/api/competence-acquises/" + result.getId()))
            .headers(HeaderUtil.ajouterAlert( ENTITY_NAME, result.getId().toString()))
            .body( mapper.toDto(result));
    }

    /**
     * PUT  /competence-acquises : Updates an existing competenceAcquise.
     *
     * @param competenceAcquiseDTO the competenceAcquiseDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated competenceAcquiseDTO,
     * or with status 400 (Bad Request) if the competenceAcquiseDTO is not valid,
     * or with status 500 (Internal Server Error) if the competenceAcquiseDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("collaborateur/{id}/competence-acquises")
    public ResponseEntity<CompetenceAcquiseDTO> updateCompetenceAcquise(
            @PathVariable Long id,
            @Valid @RequestBody CompetenceAcquiseDTO competenceAcquiseDTO ) throws URISyntaxException {
        log.debug("REST request to update CompetenceAcquise : {}", competenceAcquiseDTO);
        CompetenceAcquise result = competenceAcquiseService.save( mapper.toEntity(competenceAcquiseDTO) );
        return ResponseEntity.ok()
            .headers(HeaderUtil.editerAlert(ENTITY_NAME, result.getId().toString()))
            .body( mapper.toDto(result) );
    }

    /**
     * GET  /competence-acquises : get all the competenceAcquises.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of competenceAcquises in body
     */
    @GetMapping("/collaborateur/{id}/competence-acquises")
    public ResponseEntity<List<CompetenceAcquiseDTO>> getAllCompetenceAcquises(@PathVariable Long id) {
        log.debug("REST request to get CompetenceAcquises" );

        List<CompetenceAcquiseDTO> entityList = competenceAcquiseService.findAllByCollaborateurId(id)
                .stream()
                .map( mapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * GET  /competence-acquises/:id : get the "id" competenceAcquise.
     *
     * @param id the id of the competenceAcquiseDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the competenceAcquiseDTO, or with status 404 (Not Found)
     */
    @GetMapping("/competence-acquises/{id}")
    public ResponseEntity<CompetenceAcquiseDTO> getCompetenceAcquise(@PathVariable Long id) {
        log.debug("REST request to get CompetenceAcquise : {}", id);
        CompetenceAcquise competenceAcquise         = competenceAcquiseService.findOne( id);
        CompetenceAcquiseDTO competenceAcquiseDTO   = mapper.toDto( competenceAcquise);
        return new ResponseEntity<>( competenceAcquiseDTO, HttpStatus.OK);
    }

    /**
     * DELETE  /competence-acquises/:id : delete the "id" competenceAcquise.
     *
     * @param id the id of the competenceAcquiseDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/competence-acquises/{id}")
    public ResponseEntity<Void> deleteCompetenceAcquise(@PathVariable Long id) {
        log.debug("REST request to delete CompetenceAcquise : {}", id);
        competenceAcquiseService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.supprimerAlert(ENTITY_NAME, id.toString())).build();
    }
}
