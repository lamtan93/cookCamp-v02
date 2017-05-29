package com.cookcamp.entite;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DemandeParticuliere implements Serializable {
         @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String type;
    
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	public LignedeCommandeProduit lignedeCommandeProduit;
    
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	public LigneCommandeMenu ligneCommandeMenu;

    public DemandeParticuliere() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LignedeCommandeProduit getLignedeCommandeProduit() {
        return lignedeCommandeProduit;
    }

    public void setLignedeCommandeProduit(LignedeCommandeProduit lignedeCommandeProduit) {
        this.lignedeCommandeProduit = lignedeCommandeProduit;
    }

    public LigneCommandeMenu getLigneCommandeMenu() {
        return ligneCommandeMenu;
    }

    public void setLigneCommandeMenu(LigneCommandeMenu ligneCommandeMenu) {
        this.ligneCommandeMenu = ligneCommandeMenu;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DemandeParticuliere other = (DemandeParticuliere) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
        
}