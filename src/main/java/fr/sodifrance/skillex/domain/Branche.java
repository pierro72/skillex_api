package fr.sodifrance.skillex.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
 * A Branche.
 */
@Entity
@Table(name = "branche")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Branche implements Serializable {

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Branche brancheParente;

    @OneToMany(mappedBy = "brancheParente", fetch = FetchType.EAGER)
/*    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)*/
    private Set<Competence> competences = new HashSet<>();

    @OneToMany(mappedBy = "brancheParente" , fetch = FetchType.EAGER)
/*    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)*/
    private Set<Branche> sousBranches = new HashSet<>();

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

    public Branche nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLibelle() {
        return libelle;
    }

    public Branche libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public Branche description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Branche getBrancheParente() {
        return brancheParente;
    }

    public Branche brancheParente(Branche branche) {
        this.brancheParente = branche;
        return this;
    }

    public void setBrancheParente(Branche branche) {
        this.brancheParente = branche;
    }

    public Set<Competence> getCompetences() {
        return competences;
    }

    public Branche competences(Set<Competence> competences) {
        this.competences = competences;
        return this;
    }

    public Branche addCompetences(Competence competence) {
        this.competences.add(competence);
        competence.setBrancheParente(this);
        return this;
    }

    public Branche removeCompetences(Competence competence) {
        this.competences.remove(competence);
        competence.setBrancheParente(null);
        return this;
    }

    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }

    public Set<Branche> getSousBranches() {
        return sousBranches;
    }

    public Branche sousBranches(Set<Branche> branches) {
        this.sousBranches = branches;
        return this;
    }

    public Branche addSousBranches(Branche branche) {
        this.sousBranches.add(branche);
        branche.setBrancheParente(this);
        return this;
    }

    public Branche removeSousBranches(Branche branche) {
        this.sousBranches.remove(branche);
        branche.setBrancheParente(null);
        return this;
    }

    public void setSousBranches(Set<Branche> branches) {
        this.sousBranches = branches;
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
        Branche branche = (Branche) o;
        if (branche.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), branche.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Branche{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
