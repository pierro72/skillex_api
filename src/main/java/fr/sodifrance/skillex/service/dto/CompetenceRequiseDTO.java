package fr.sodifrance.skillex.service.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the CompetenceRequise entity.
 */
public class CompetenceRequiseDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private Integer note;

    @NotNull
    private Long equipeId;

    private CompetenceDTO competence;

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

    public Long getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(Long equipeId) {
        this.equipeId = equipeId;
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

        CompetenceRequiseDTO competenceRequiseDTO = (CompetenceRequiseDTO) o;
        if(competenceRequiseDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), competenceRequiseDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CompetenceRequiseDTO{" +
            "id=" + getId() +
            ", note='" + getNote() + "'" +
            ", equipeId='" + getEquipeId() + "'" +
            "}";
    }
}
