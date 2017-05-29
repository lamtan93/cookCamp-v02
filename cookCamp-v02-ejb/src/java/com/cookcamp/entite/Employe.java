
package com.cookcamp.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Employe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(nullable = false, length = 200)
    private String nom;
    @Column(nullable = false, length = 200)
    private String prenom;
    @Column(nullable = false, length = 200)
    private String login;

    @ManyToMany(mappedBy = "employes")
    Collection<Fonction> fonctions;
    
    public Employe() {
        fonctions = new ArrayList<>();
    }

    public Employe(String nom, String prenom, String login) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Collection<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(Collection<Fonction> fonctions) {
        this.fonctions = fonctions;
    }
    
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nom: "+ this.nom + ""+ "prenom: "+ this.prenom+ "";
    }
    
}
