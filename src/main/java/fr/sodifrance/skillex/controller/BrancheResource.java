package fr.sodifrance.skillex.controller;

import fr.sodifrance.skillex.domain.Branche;
import fr.sodifrance.skillex.service.BrancheService;
import fr.sodifrance.skillex.service.dto.BrancheDTO;
import fr.sodifrance.skillex.service.mapper.BrancheMapper;
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
 * REST controller for managing Branche.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class BrancheResource {

    private final Logger log = LoggerFactory.getLogger(BrancheResource.class);
    private static final String ENTITY_NAME = "branche";
    private final BrancheService brancheService;
    private final BrancheMapper mapper;


    public BrancheResource ( BrancheService brancheService, BrancheMapper mapper) {
        this.brancheService  = brancheService;
        this.mapper = mapper;
    }

    /**
     * POST  /branches : Create a new branche.
     *
     * @param brancheDTO the brancheDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new brancheDTO, or with status 400 (Bad Request) if the branche has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/branches")
    public ResponseEntity<BrancheDTO> createBranche(@Valid @RequestBody BrancheDTO brancheDTO) throws URISyntaxException {
        log.debug("REST request to save Branche : {}", brancheDTO);
        Branche branche = mapper.toEntity(brancheDTO);
        Branche result = brancheService.save(branche);
        BrancheDTO resultDTO = mapper.toDto(branche);
        return ResponseEntity.created(
                new URI("/api/branches/" + result.getId()))
                .headers(HeaderUtil.ajouterAlert(ENTITY_NAME, result.getId().toString()))
                .body(resultDTO);
    }

    /**
     * PUT  /branches : Updates an existing branche.
     *
     * @param brancheDTO the brancheDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated brancheDTO,
     * or with status 400 (Bad Request) if the brancheDTO is not valid,
     * or with status 500 (Internal Server Error) if the brancheDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/branches")
    public ResponseEntity<BrancheDTO> updateBranche(@Valid @RequestBody BrancheDTO brancheDTO) throws URISyntaxException {
        log.debug("REST request to update Branche : {}", brancheDTO);
        if (brancheDTO.getId() == null) { return createBranche(brancheDTO); }
        Branche result = brancheService.save( mapper.toEntity(brancheDTO));
        return ResponseEntity.ok()
            .headers(HeaderUtil.editerAlert(ENTITY_NAME, brancheDTO.getId().toString()))
            .body(mapper.toDto(result));
    }


    /**
     * GET  /branches : get all the branches.
     * @return the ResponseEntity with status 200 (OK) and the list of branches in body
     */
    @GetMapping("/branches")
    public ResponseEntity<List<BrancheDTO>> getAllBranches( ) {
        log.debug("REST request to get Branches parentes : {}");
        List<Branche> branches = brancheService.findAllBrancheParent();
        return ResponseEntity.ok().body(  mapper.toDto(branches) );
    }

    /**
     * GET  /branches/:id : get the "id" branche.
     *
     * @param id the id of the brancheDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the brancheDTO, or with status 404 (Not Found)
     */
    @GetMapping("/branches/{id}")
    public ResponseEntity<BrancheDTO> getBranche(@PathVariable Long id) {
        log.debug("REST request to get Branche : {}", id);
        Branche branche = brancheService.findOne(id);
        return new ResponseEntity<>( mapper.toDto(branche) , HttpStatus.OK);
    }

    /**
     * DELETE  /branches/:id : delete the "id" branche.
     *
     * @param id the id of the brancheDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/branches/{id}")
    public ResponseEntity<Void> deleteBranche(@PathVariable Long id) {
        log.debug("REST request to delete Branche : {}", id);
        brancheService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.supprimerAlert(ENTITY_NAME, id.toString())).build();
    }

}
