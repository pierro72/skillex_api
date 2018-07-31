package fr.sodifrance.skillex.service.dto;
import java.io.Serializable;
import java.util.List;


/**
 * A DTO for the Competence entity.
 */
public class CollaborateurDTO implements Serializable {

    private long id;

    private String nom;

    private String prenom;

    private String pseudo;

    private Boolean admin;

    private String poste;

    private String mail;

    private List<CompetenceAcquiseDTO> competenceAcquises;

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

    public List<CompetenceAcquiseDTO> getCompetenceAcquises() {
        return competenceAcquises;
    }

    public void setCompetenceAcquises(List<CompetenceAcquiseDTO> competenceAcquises) {
        this.competenceAcquises = competenceAcquises;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
