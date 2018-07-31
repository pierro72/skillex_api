package fr.sodifrance.skillex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * Service Implementation for managing Collaborateur.
 */
@Service
@Transactional
public class AuthentificationService {

    @Value("${service.ihni.loginRessource}")
    private String loginRessource;

    private final Logger log = LoggerFactory.getLogger(AuthentificationService.class);
    private final CompetenceAcquiseService competenceAcquiseService;
    private final RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    private final RestTemplate restTemplate;

    public AuthentificationService(CompetenceAcquiseService competenceAcquiseService ) {
        this.restTemplate               = restTemplateBuilder.build();
        this.competenceAcquiseService   = competenceAcquiseService;
    }

    /**
     *  Get current collaborateur
     *
     *  @return the entity
     */
/*    @Transactional(readOnly = true)
    public AuthentificationDTO findCurrent(@RequestHeader(value = "Cookie") String cookieRaw) throws IOException {
        String phpSESSID = this.getPHPSESSID(cookieRaw);
        String url                          = loginRessource;
        HttpHeaders requestHeaders          = new HttpHeaders();
        requestHeaders.add("Cookie", phpSESSID);
        HttpEntity requestEntity            = new HttpEntity(null, requestHeaders);
        ResponseEntity< AuthentificationDTO> response                  = new RestTemplate().exchange(url  ,HttpMethod.GET, requestEntity, AuthentificationDTO.class);

        return collaborateur;
    }*/

    public String getPHPSESSID(String cookieRaw){
        String[] cookieBag = cookieRaw.split(";");

        for (String cookieElem : cookieBag) {
            if (cookieElem.contains("PHPSESSID")) {
                return cookieElem;
            }
        }
        return "";
    }


}
