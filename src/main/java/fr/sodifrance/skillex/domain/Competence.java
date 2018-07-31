package fr.sodifrance.skillex.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Competence.
 */
@Entity
@Table(name = "competence")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Competence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100 )
    @Column(name = "nom", length = 100)
    private String nom;

    @NotNull
    @Size(max = 50)
    @Column(name = "libelle", length = 50, nullable = false)
    private String libelle;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false,  fetch = FetchType.LAZY)
    @NotNull
    private Branche brancheParente;

    @OneToMany(mappedBy = "competence")
    @JsonIgnore
/*    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)*/
    private Set<CompetenceAcquise> competenceAcquises = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Competence nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLibelle() {
        return libelle;
    }

    public Competence libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public Competence description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Branche getBrancheParente() {
        return brancheParente;
    }

    public Competence brancheParente(Branche branche) {
        this.brancheParente = branche;
        return this;
    }

    public void setBrancheParente(Branche branche) {
        this.brancheParente = branche;
    }

    public Set<CompetenceAcquise> getCompetenceAcquises() {
        return competenceAcquises;
    }

    public Competence competenceAcquises(Set<CompetenceAcquise> CompetenceAcquises) {
        this.competenceAcquises = CompetenceAcquises;
        return this;
    }

    public Competence addCompetenceAcquises(CompetenceAcquise CompetenceAcquise) {
        this.competenceAcquises.add(CompetenceAcquise);
        CompetenceAcquise.setCompetence(this);
        return this;
    }

    public Competence removeCompetenceAcquises(CompetenceAcquise CompetenceAcquise) {
        this.competenceAcquises.remove(CompetenceAcquise);
        CompetenceAcquise.setCompetence(null);
        return this;
    }

    public void setCompetenceAcquises(Set<CompetenceAcquise> CompetenceAcquises) {
        this.competenceAcquises = CompetenceAcquises;
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
        Competence competence = (Competence) o;
        if (competence.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), competence.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Competence{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
