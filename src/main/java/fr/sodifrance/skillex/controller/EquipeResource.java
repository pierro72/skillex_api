package fr.sodifrance.skillex.controller;

import fr.sodifrance.skillex.domain.Equipe;
import fr.sodifrance.skillex.service.EquipeService;
import fr.sodifrance.skillex.service.dto.EquipeDTO;
import fr.sodifrance.skillex.service.dto.EquipeSoftDTO;
import fr.sodifrance.skillex.service.mapper.EquipeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * REST controller for managing Equipe.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class EquipeResource {

    private final Logger log = LoggerFactory.getLogger(EquipeResource.class);
    private static final String ENTITY_NAME = "equipe";
    private final EquipeService equipeService;
    private final EquipeMapper equipeMapper;

    public EquipeResource(EquipeService equipeService , EquipeMapper equipeMapper) {
        this.equipeService = equipeService;
        this.equipeMapper = equipeMapper;
    }

    /**
     * GET  /collaborateurs : get all the collaborateurs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of collaborateurs in body
     */
    @GetMapping("/equipes")
    public ResponseEntity< List<EquipeSoftDTO> > getAllEquipes(@RequestHeader(value = "Cookie") String cookieRaw ) throws IOException {
        log.debug("REST request to get all Equipe");
        List<Equipe> equipes = equipeService.findAll(cookieRaw);
        List<EquipeSoftDTO> equipesDTO = equipeMapper.toSoftDto(equipes);
        return ResponseEntity.ok().body(equipesDTO);
    }

    /**
     * GET  /equipes/:id : get the "id" equipe.
     *
     * @param id the id of the equipe to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the equipe, or with status 404 (Not Found)
     */
    @GetMapping("/equipes/{id}")
    public ResponseEntity< EquipeDTO> getEquipe(@RequestHeader(value = "Cookie") String cookieRaw , @PathVariable long id) throws IOException {
        log.debug("REST request to get Equipe : {}", id);
        Equipe equipe = equipeService.findOne(cookieRaw, id);
        EquipeDTO equipeDTO= equipeMapper.toDto(equipe);
        return new ResponseEntity<>(equipeDTO, HttpStatus.OK);
    }



}
