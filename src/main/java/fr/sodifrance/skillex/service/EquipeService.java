package fr.sodifrance.skillex.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.sodifrance.skillex.domain.Collaborateur;
import fr.sodifrance.skillex.domain.CompetenceAcquise;
import fr.sodifrance.skillex.domain.CompetenceRequise;
import fr.sodifrance.skillex.domain.Equipe;
import fr.sodifrance.skillex.repository.CompetenceRequiseRepository;
import fr.sodifrance.skillex.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

;

/**
 * Service Implementation for managing Equipe.
 */
@Service
public class EquipeService {

    @Value("${service.ihni.teamRessource}")
    private String teamRessource;

    private final CompetenceRequiseService competenceRequiseService;
    private final CompetenceAcquiseService competenceAcquiseService;
    private final CollaborateurService collaborateurService;
    private final RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    private final RestTemplate restTemplate;
    private final CompetenceRequiseRepository competenceRequiseRepository;
    private final Logger log = LoggerFactory.getLogger(EquipeService.class);

    /*CONSTRUCTEUR*/
    public EquipeService(CompetenceRequiseRepository competenceRequiseRepository,
                         CompetenceRequiseService competenceRequiseService,
                         CollaborateurService collaborateurService,
                         CompetenceAcquiseService competenceAcquiseService) {
        this.competenceRequiseRepository    = competenceRequiseRepository;
        this.competenceRequiseService       = competenceRequiseService;
        this.collaborateurService           = collaborateurService;
        this.competenceAcquiseService       = competenceAcquiseService;
        this.restTemplate                   = restTemplateBuilder.build();
    }

    /**
     *  Get one equipe by id.
     *  @param id the id of the entity
     *  @return the entity
     */
    public Equipe findOne(String phpSESSID, long id) throws IOException {
        log.debug("Request to get Equipe : {}", id);
        RestTemplate restTemplate = new RestTemplate();
        String url = teamRessource+"/"+id;
        HttpEntity httpEntity = HeaderUtil.getHeaderWithCookie(phpSESSID);

        ResponseEntity<String> jsonResponse = new RestTemplate().exchange(url,HttpMethod.GET, httpEntity, String.class);

        ObjectMapper mapper         = new ObjectMapper();
        JsonNode rootNode           = mapper.readTree(jsonResponse.getBody());
        JsonNode infoNode           = rootNode.path("info");
        JsonNode usersNode          = rootNode.path("users");
        List<Collaborateur> collaborateurs = new ArrayList<>();
        for ( JsonNode userNode : usersNode){
            JsonNode userInUserNode           = userNode.path("user");
            Collaborateur collaborateur = mapper.treeToValue(userInUserNode, Collaborateur.class);
            List<CompetenceAcquise> entityList  = competenceAcquiseService.findAllByCollaborateurId(collaborateur.getId());
            collaborateur.setCompetenceAcquises(entityList);
            collaborateurs.add(collaborateur);
        }

        Equipe equipe  = mapper.treeToValue(infoNode, Equipe.class);
        List<CompetenceRequise> entityList  = competenceRequiseService.findAllByEquipeId(equipe.getId());
        equipe.setCompetenceRequises(entityList);
        equipe.setCollaborateurs(collaborateurs);
        return equipe;
    }

    /**
     *  Get all the Equipe.
     *  @return the list of entities
     */
/*
    public List<Equipe> findAll(String phpSESSID) throws IOException {
        List<Equipe> equipes  = new ArrayList<>();
        String url = teamRessource;
        HttpEntity httpEntity = HeaderUtil.getHeaderWithCookie(phpSESSID);
        ResponseEntity<String> jsonResponse = new RestTemplate().exchange(url,HttpMethod.GET, httpEntity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonResponse.getBody());

        for ( JsonNode elementNode : rootNode){
            JsonNode test = elementNode.path("team");
            JsonNode idNode   = test.path("id");
            long id = idNode.asLong();
            equipes.add(this.findOne(phpSESSID, id ));
        }
        return equipes;
    }
*/

    /**
     *  Get all the Equipe.
     *  @return the list of entities
     */
    public List<Equipe> findAll(String phpSESSID) throws IOException {
        List<Equipe> equipes  = new ArrayList<>();
        String url = teamRessource;
        HttpEntity httpEntity = HeaderUtil.getHeaderWithCookie(phpSESSID);
        ResponseEntity<String> jsonResponse = new RestTemplate().exchange(url,HttpMethod.GET, httpEntity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonResponse.getBody());

        for ( JsonNode elementNode : rootNode){
            Equipe equipe = mapper.treeToValue(elementNode.path("team"), Equipe.class);
            equipes.add(equipe);
        }
        return equipes;
    }
}
