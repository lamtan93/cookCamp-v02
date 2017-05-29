package com.cookcamp.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries({
    @NamedQuery(name = "FindCommandes", query = "SELECT DISTINCT c FROM Commande c where c.emplacement IS NOT NULL "),
    @NamedQuery(name = "FindCommandeById", query = "SELECT c.ldcp FROM Commande c WHERE c.id=:numCo"),
    @NamedQuery(name = "FindOnlyCommandeId", query = "SELECT c FROM Commande c WHERE c.id=:numCo"),

//Requete Abdel
//@NamedQuery(name = "FindCommandes",query = "SELECT DISTINCT c FROM Commande c where c.emplacement IS NOT NULL "),
//@NamedQuery(name="FindCommandeById",query="SELECT c.ldcp FROM Commande c WHERE c.id=:numCo"),
    @NamedQuery(name = "com.cookcamp.entite.Commande.findAllCommande", query = "select c from Commande c"),
    
    
    //Omar---
    
    
@NamedQuery(name = "FindCommandes",query = "SELECT DISTINCT c FROM Commande c where c.emplacement IS NOT NULL "),
@NamedQuery(name="FindCommandeById",query="SELECT c.ldcp FROM Commande c WHERE c.id=:numCo"),
@NamedQuery(name="com.cookcamp.entite.Commande.findAllCommande", query="select c from Commande c"),
@NamedQuery(name="com.cookcamp.entite.Commande.findCommandeEnCours", query="SELECT c FROM Commande c WHERE c.etat= :paramEtat"),
})

@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String etat;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Emplacement emplacement;
    @OneToMany(mappedBy = "commande")
    private List<LigneCommandeMenu> ldcm;

    @OneToMany(mappedBy = "commande")
    private List<LignedeCommandeProduit> ldcp;
    @OneToOne
    private Paiement paiement;

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public Commande() {
        ldcm = new ArrayList();
        ldcp = new ArrayList();
        emplacement = new Emplacement();
    }

    public Commande(String etat) {
        this();
        this.etat = etat;
    }

    public Commande(String etat, Emplacement emplacement) {
        this();
        this.etat = etat;
        this.emplacement = emplacement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    public List<LigneCommandeMenu> getLdcm() {
        return ldcm;
    }

    public void setLdcm(List<LigneCommandeMenu> ldcm) {
        this.ldcm = ldcm;
    }

    public List<LignedeCommandeProduit> getLdcp() {
        return ldcp;
    }

    public void setLdcp(List<LignedeCommandeProduit> ldcp) {
        this.ldcp = ldcp;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BeanEntites.Commande[ id=" + id + " ]";
    }

}
