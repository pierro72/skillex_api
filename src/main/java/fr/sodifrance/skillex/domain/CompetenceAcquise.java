package fr.sodifrance.skillex.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A CompetenceAcquise.
 */
@Entity
@Table(name = "competence_acquise")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CompetenceAcquise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull( message = "L’évaluation d'une compétence doit être comprise entre 1 et 5.")
    @Min(value = 1, message = "L’évaluation d'une compétence doit être comprise entre 1 et 5.")
    @Max(value = 5, message = "L’évaluation d'une compétence doit être comprise entre 1 et 5.")
    @Column(name = "note", nullable = false)
    private Integer note;

    @NotNull
    @Column(name = "collaborateur_id", nullable = false)
    private Long collaborateurId;

    @ManyToOne(optional = false)
    @NotNull
    private Competence competence;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNote() {
        return note;
    }

    public CompetenceAcquise note(Integer note) {
        this.note = note;
        return this;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Long getCollaborateurId() {
        return collaborateurId;
    }

    public CompetenceAcquise collaborateurId(Long collaborateurId) {
        this.collaborateurId = collaborateurId;
        return this;
    }

    public void setCollaborateurId(Long collaborateurId) {
        this.collaborateurId = collaborateurId;
    }

    public Competence getCompetence() {
        return competence;
    }

    public CompetenceAcquise competence(Competence competence) {
        this.competence = competence;
        return this;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompetenceAcquise competenceAcquise = (CompetenceAcquise) o;
        if (competenceAcquise.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), competenceAcquise.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CompetenceAcquise{" +
            "id=" + getId() +
            ", note='" + getNote() + "'" +
            ", collaborateurId='" + getCollaborateurId() + "'" +
            "}";
    }
}
