package fr.sodifrance.skillex.controller;


import fr.sodifrance.skillex.service.AuthentificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing Collaborateur.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthentificationController {

    private final Logger log = LoggerFactory.getLogger(CompetenceResource.class);
    private final AuthentificationService authentificationService;

    public AuthentificationController( AuthentificationService authentificationService){
        this.authentificationService = authentificationService;
    }

/*    @GetMapping("/equipe/{id}/authentification")
    public ResponseEntity<AuthentificationDTO> authentification(@PathVariable long id) throws IOException {
        log.debug("REST request to get collaborateur et son role dans l'equipe");
        AuthentificationDTO compte = authentificationService.findCurrent()
        return ResponseEntity.ok().body(compte);
    }*/
}
