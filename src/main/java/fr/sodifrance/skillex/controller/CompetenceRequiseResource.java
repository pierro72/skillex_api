package fr.sodifrance.skillex.controller;

import fr.sodifrance.skillex.domain.CompetenceRequise;
import fr.sodifrance.skillex.service.CompetenceRequiseService;
import fr.sodifrance.skillex.service.dto.CompetenceRequiseDTO;
import fr.sodifrance.skillex.service.mapper.CompetenceRequiseMapper;
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
 * REST controller for managing CompetenceRequise.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class CompetenceRequiseResource {

    private final Logger log = LoggerFactory.getLogger(CompetenceRequiseResource.class);
    private static final String ENTITY_NAME = "competenceRequise";
    private final CompetenceRequiseService competenceRequiseService;
    private final CompetenceRequiseMapper mapper;

    public CompetenceRequiseResource(
            CompetenceRequiseService competenceRequiseService,
            CompetenceRequiseMapper mapper)
    {
        this.competenceRequiseService = competenceRequiseService;
        this.mapper = mapper;
    }

    /**
     * POST  /competence-requises : Create a new competenceRequise.
     *
     * @param entityDTO the competenceRequiseDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new competenceRequiseDTO, or with status 400 (Bad Request) if the competenceRequise has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/equipe/{id}/competence-requises")
    public ResponseEntity<CompetenceRequiseDTO> createCompetenceRequise(
            @PathVariable Long id,
            @Valid @RequestBody CompetenceRequiseDTO entityDTO) throws URISyntaxException {
        log.debug("REST request to save CompetenceRequise : {}", entityDTO);
        CompetenceRequise result = competenceRequiseService.save( mapper.toEntity(entityDTO));
        return ResponseEntity.created(
                new URI("/api/competence-requises/" + result.getId()))
                .headers(HeaderUtil.ajouterAlert( ENTITY_NAME, result.getId().toString()))
                .body( mapper.toDto(result));
    }

    /**
     * PUT  /competence-requises : Updates an existing competenceRequise.
     *
     * @param entityDTO the competenceRequiseDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated competenceRequiseDTO,
     * or with status 400 (Bad Request) if the competenceRequiseDTO is not valid,
     * or with status 500 (Internal Server Error) if the competenceRequiseDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/equipe/{id}/competence-requises")
    public ResponseEntity<CompetenceRequiseDTO> updateCompetenceRequise(@PathVariable Long id, @Valid @RequestBody CompetenceRequiseDTO entityDTO) throws URISyntaxException {
        log.debug("REST request to update CompetenceRequise : {}", entityDTO);
        CompetenceRequise result = competenceRequiseService.save( mapper.toEntity(entityDTO));
        return ResponseEntity.ok()
            .headers(HeaderUtil.editerAlert(ENTITY_NAME, result.getId().toString()))
            .body( mapper.toDto(result) );
    }

    /**
     * GET  /competence-requises : get all the competenceRequises.
     * @return the ResponseEntity with status 200 (OK) and the list of competenceRequises in body
     */
    @GetMapping("/equipe/{id}/competence-requises")
    public ResponseEntity< List<CompetenceRequiseDTO> > getAllCompetenceRequises(@PathVariable Long id ) {
        log.debug("REST request to get CompetenceRequises");
        List<CompetenceRequise> entityList = competenceRequiseService.findAllByEquipeId( id );
        return ResponseEntity.ok().body(mapper.toDto(entityList));
    }

    /**
     * GET  /competence-requises/:id : get the "id" competenceRequise.
     *
     * @param id the id of the competenceRequiseDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the competenceRequiseDTO, or with status 404 (Not Found)
     */
    @GetMapping("/competence-requises/{id}")
    public ResponseEntity< CompetenceRequiseDTO> getCompetenceRequise(@PathVariable Long id) {
        log.debug("REST request to get CompetenceRequise : {}", id);
        CompetenceRequise entity = competenceRequiseService.findOne(id);
        return new ResponseEntity<>( mapper.toDto(entity), HttpStatus.OK);
    }

    /**
     * DELETE  /competence-requises/:id : delete the "id" competenceRequise.
     *
     * @param id the id of the competenceRequiseDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/competence-requises/{id}")
    public ResponseEntity<Void> deleteCompetenceRequise(@PathVariable Long id) {
        log.debug("REST request to delete CompetenceRequise : {}", id);
        competenceRequiseService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.supprimerAlert(ENTITY_NAME, id.toString())).build();
    }
}
