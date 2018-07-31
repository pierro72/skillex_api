package fr.sodifrance.skillex.service.dto;

import java.io.Serializable;

/**
 * A Equipe.
 */

public class EquipeSoftDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String nom;

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

}


