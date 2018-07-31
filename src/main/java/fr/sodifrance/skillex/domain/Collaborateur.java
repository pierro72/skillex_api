package fr.sodifrance.skillex.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A Collaborateur.
 */

@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@JsonIgnoreProperties({"createdBy","createdAt", "activeAt", "activeUntil", "birthDate", "bornDate"})
public class Collaborateur implements Serializable {


    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private long id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    @JsonProperty("username")
    private String pseudo;

    @JsonProperty("admin")
    private Boolean admin;

    @JsonProperty("jobName")
    private String poste;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("mail")
    private String mail;

    private List<RoleEquipe> roleEquipes;

    private List<CompetenceAcquise> competenceAcquises;


    /*getter setter*/
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<CompetenceAcquise> getCompetenceAcquises() {
        return competenceAcquises;
    }

    public void setCompetenceAcquises(List<CompetenceAcquise> competenceAcquises) {
        this.competenceAcquises = competenceAcquises;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<RoleEquipe> getRoleEquipes() {
        return roleEquipes;
    }

    public void setRoleEquipes(List<RoleEquipe> roleEquipes) {
        this.roleEquipes = roleEquipes;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Collaborateur{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            "}";
    }
}
