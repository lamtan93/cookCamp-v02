package com.cookcamp.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Emplacement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String numero;
    private int capacite;
    private String etat;
    @OneToMany(mappedBy = "emplacement")
    private Collection<Commande> commandes;

    public Emplacement() {
        commandes=new ArrayList<>();
        
    }

    public Emplacement(String numero, int capacite, String etat) {
        this();
        this.numero = numero;
        this.capacite = capacite;
        this.etat = etat;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }
    

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the numero fields are not set
        if (!(object instanceof Emplacement)) {
            return false;
        }
        Emplacement other = (Emplacement) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BeanEntites.Emplacement[ id=" + numero + " ]";
    }
    
}
