package fr.sodifrance.skillex.controller;


import fr.sodifrance.skillex.domain.Collaborateur;
import fr.sodifrance.skillex.service.AuthentificationService;
import fr.sodifrance.skillex.service.CollaborateurService;
import fr.sodifrance.skillex.service.dto.CollaborateurDTO;
import fr.sodifrance.skillex.service.mapper.CollaborateurMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


/**
 * REST controller for managing Collaborateur.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class CollaborateurResource {

    @Autowired
    AuthentificationService authService;

    private final Logger log = LoggerFactory.getLogger(CollaborateurResource.class);
    private static final String ENTITY_NAME = "collaborateur";
    private final CollaborateurService collaborateurService;

    @Value("${service.ihni.loginIhni}")
    private String loginIhni;
    private final CollaborateurMapper mapper;

    public CollaborateurResource ( CollaborateurService collaborateurService, CollaborateurMapper mapper) {
        this.collaborateurService   = collaborateurService;
        this.mapper    = mapper;
    }

    /**
     * GET  /collaborateurs : get all the collaborateurs.
     * @return the ResponseEntity with status 200 (OK) and the list of collaborateurs in body
     */
    @GetMapping("/collaborateurs")
    public ResponseEntity<List<CollaborateurDTO>> getAllCollaborateurs(@RequestHeader(value = "Cookie") String cookieRaw) throws IOException {
        log.debug("REST request to get all Collaborateurs");
        String phpSESSID = this.authService.getPHPSESSID(cookieRaw);
        List<Collaborateur> entityList = collaborateurService.findAll(phpSESSID);

        return ResponseEntity.ok().body( mapper.toDto(entityList));
        }

    /**
     * GET  /collaborateurs/:id : get the "id" collaborateur.
     * @param id the id of the collaborateur to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the collaborateur, or with status 404 (Not Found)
     */
    @GetMapping("/collaborateurs/{id}")
    public ResponseEntity<CollaborateurDTO> getCollaborateur(@RequestHeader(value = "Cookie") String cookieRaw, @PathVariable long id) throws IOException {
        log.debug("REST request to get Collaborateur : {}", id);
        String phpSESSID = this.authService.getPHPSESSID(cookieRaw);
        Collaborateur entity = collaborateurService.findOne(id, phpSESSID);
        return new ResponseEntity<>(mapper.toDto(entity), HttpStatus.OK);
    }

}
