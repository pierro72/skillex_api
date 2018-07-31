package fr.sodifrance.skillex.service.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the CompetenceAcquise entity.
 */
public class CompetenceAcquiseDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private Integer note;

    @NotNull
    private Long collaborateurId;

    private CompetenceDTO competence;

    /*Getter & Setter*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Long getCollaborateurId() {
        return collaborateurId;
    }

    public void setCollaborateurId(Long collaborateurId) {
        this.collaborateurId = collaborateurId;
    }

    public CompetenceDTO getCompetence() {
        return competence;
    }

    public void setCompetence(CompetenceDTO competence) {
        this.competence = competence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CompetenceAcquiseDTO competenceAcquiseDTO = (CompetenceAcquiseDTO) o;
        if(competenceAcquiseDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), competenceAcquiseDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CompetenceAcquiseDTO{" +
            "id=" + getId() +
            ", note='" + getNote() + "'" +
            ", collaborateurId='" + getCollaborateurId() + "'" +
            "}";
    }
}
