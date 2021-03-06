package fr.sodifrance.skillex.service.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the Branche entity.
 */

public class BrancheDTO implements Serializable {

    private Long id;

    @Size(max = 100)
    private String nom;

    @NotNull
    @Size(max = 50)
    private String libelle;

    private String description;

    private Long brancheParenteId;

    private Set<CompetenceDTO> competences;

    private Set<BrancheDTO> sousBranches;

    /*Getter & setter*/

    public Set<CompetenceDTO> getCompetences() {
        return competences;
    }

    public void setCompetences(Set<CompetenceDTO> competences) {
        this.competences = competences;
    }

    public Set<BrancheDTO> getSousBranches() {
        return sousBranches;
    }
    public void setSousBranches(Set<BrancheDTO> sousBranches) {
        this.sousBranches = sousBranches;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBrancheParenteId() {
        return brancheParenteId;
    }
    public void setBrancheParenteId(Long brancheId) {
        this.brancheParenteId = brancheId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BrancheDTO brancheDTO = (BrancheDTO) o;
        if(brancheDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), brancheDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BrancheDTO{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
