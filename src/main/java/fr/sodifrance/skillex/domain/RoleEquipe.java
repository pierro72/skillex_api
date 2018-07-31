package fr.sodifrance.skillex.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;

/**
 * A RoleEquipe.
 */

@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class RoleEquipe implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    @JsonProperty("role")
    private String role;

    private Equipe equipe;

    private Collaborateur collaborateur;


    //GETTER SETTER

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }
}
