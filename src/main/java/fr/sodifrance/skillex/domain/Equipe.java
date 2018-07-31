package fr.sodifrance.skillex.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import java.util.List;

/**
 * A Equipe.
 */

@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@JsonIgnoreProperties({"createdAt", "modules"})
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String nom;

    @JsonProperty("pilote")
    private Collaborateur pilote;

    private List<CompetenceRequise> competenceRequises;

    private List<Collaborateur>     collaborateurs;


    //GETTER SETTER
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<CompetenceRequise> getCompetenceRequises() {
        return competenceRequises;
    }

    public void setCompetenceRequises(List<CompetenceRequise> competenceRequises) {
        this.competenceRequises = competenceRequises;
    }

    public List<Collaborateur> getCollaborateurs() {
        return collaborateurs;
    }

    public void setCollaborateurs(List<Collaborateur> collaborateurs) {
        this.collaborateurs = collaborateurs;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Collaborateur getPilote() {
        return pilote;
    }

    public void setPilote(Collaborateur pilote) {
        this.pilote = pilote;
    }
}
