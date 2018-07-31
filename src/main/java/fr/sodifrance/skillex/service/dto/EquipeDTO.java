package fr.sodifrance.skillex.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * A Equipe.
 */


public class EquipeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String nom;

    private CollaborateurDTO pilote;

    private List<CompetenceRequiseDTO> competenceRequises;

    private List<CollaborateurDTO>     collaborateurs;

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

    public CollaborateurDTO getPilote() {
        return pilote;
    }

    public void setPilote(CollaborateurDTO pilote) {
        this.pilote = pilote;
    }

    public List<CompetenceRequiseDTO> getCompetenceRequises() {
        return competenceRequises;
    }

    public void setCompetenceRequises(List<CompetenceRequiseDTO> competenceRequises) {
        this.competenceRequises = competenceRequises;
    }

    public List<CollaborateurDTO> getCollaborateurs() {
        return collaborateurs;
    }

    public void setCollaborateurs(List<CollaborateurDTO> collaborateurs) {
        this.collaborateurs = collaborateurs;
    }
}


