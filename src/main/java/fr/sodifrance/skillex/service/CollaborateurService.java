package fr.sodifrance.skillex.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fr.sodifrance.skillex.domain.Collaborateur;
import fr.sodifrance.skillex.domain.CompetenceAcquise;
import fr.sodifrance.skillex.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Service Implementation for managing Collaborateur.
 */
@Service
public class CollaborateurService {

    @Value("${service.ihni.userRessource}")
    private String userRessource;
    @Value("${service.ihni.usersRessource}")
    private String usersRessource;
    @Value("${service.ihni.loginRessource}")
    private String loginRessource;

    private final Logger log = LoggerFactory.getLogger(CollaborateurService.class);
    private final CompetenceAcquiseService competenceAcquiseService;
    private final RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    private final RestTemplate restTemplate;

    public CollaborateurService( CompetenceAcquiseService competenceAcquiseService ) {
        this.restTemplate               = restTemplateBuilder.build();
        this.competenceAcquiseService   = competenceAcquiseService;
    }

    /**
     *  Get all the collaborateurs.
     *
     *  @return the list of entities
     */
    public List<Collaborateur> findAll(String phpSESSID) throws IOException {
        List<Collaborateur> collaborateurs  = new ArrayList<>();
        ResponseEntity<String> jsonResponse = new RestTemplate().exchange(
                usersRessource,
                HttpMethod.GET,
                HeaderUtil.getHeaderWithCookie(phpSESSID),
                String.class);
        ObjectMapper mapper                 = new ObjectMapper();
        ArrayNode mainNode                  = mapper.readValue(jsonResponse.getBody(), ArrayNode.class);
        Iterator<JsonNode> iterator         = mainNode.elements();
        while( iterator.hasNext()){
            JsonNode arrayNode  = iterator.next();
            JsonNode userNode   = arrayNode.path("user");
            Collaborateur collaborateur = mapper.treeToValue(userNode, Collaborateur.class);
            List<CompetenceAcquise> entityList  = competenceAcquiseService.findAllByCollaborateurId(collaborateur.getId());
            collaborateur.setCompetenceAcquises(entityList);
            collaborateurs.add(collaborateur);
        }
        return collaborateurs;
    }

    /**
     *  Get one collaborateur by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Collaborateur findOne(long id, String phpSESSID) throws IOException {

        ResponseEntity<String> jsonResponse = new RestTemplate().exchange(
                userRessource+"/"+id,
                HttpMethod.GET,
                HeaderUtil.getHeaderWithCookie(phpSESSID),
                String.class);
        ObjectMapper mapper                 = new ObjectMapper();
        JsonNode rootNode                   = mapper.readValue(jsonResponse.getBody(), JsonNode.class);
        JsonNode infoNode                   = rootNode.path("info");
        JsonNode rolesNode                  = rootNode.path("equipes_role");
        Collaborateur collaborateur         = mapper.treeToValue(infoNode, Collaborateur.class);
        List<CompetenceAcquise> entityList  = competenceAcquiseService.findAllByCollaborateurId(collaborateur.getId());
        collaborateur.setCompetenceAcquises(entityList);
        return collaborateur;
    }

}
