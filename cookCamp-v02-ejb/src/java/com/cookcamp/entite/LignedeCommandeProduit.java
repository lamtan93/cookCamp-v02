/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookcamp.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
    @NamedQuery(name = "com.cookcamp.entite.LignedeCommandeProduit.FindByCommande", query = "SELECT ldcp FROM LignedeCommandeProduit ldcp  WHERE ldcp.commande.id= :commandeId"),
    //@NamedQuery(name = "com.cookcamp.entite.LignedeCommandeProduit.FindAll", query = "SELECT ldcp FROM LignedeCommandeProduit ldcp WHERE ldcp.commande.id IS NOT NULL "),
    @NamedQuery(name = "FindListeById", query = "SELECT ldcp FROM LignedeCommandeProduit ldcp where ldcp.commande.id= :numCo"),

//-----------Abdel----------------
 @NamedQuery(name = "com.cookcamp.entite.LignedeCommandeProduit.FindByLcpByCommande", query = "SELECT ldcp FROM LignedeCommandeProduit ldcp  WHERE ldcp.commande.id= :commandeId"),
@NamedQuery(name = "com.cookcamp.entite.LignedeCommandeProduit.FindAll", query = "SELECT ldcp.commande FROM LignedeCommandeProduit ldcp WHERE ldcp.commande.id = :commandeId ")

,
})
@Entity
public class LignedeCommandeProduit implements Serializable {

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

    private int quantite;
    private float prix;
    private float tva;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Produit produit;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Commande commande;

    @OneToMany(mappedBy = "lignedeCommandeProduit")
    private Collection<DemandeParticuliere> demandeParticulieres;

    public LignedeCommandeProduit() {
        demandeParticulieres = new ArrayList<>();
        //commande=new Commande();
        //produit=new Produit();
    }

    public LignedeCommandeProduit(int quantite, float prix, float tva) {
        this();
        this.quantite = quantite;
        this.prix = prix;
        this.tva = tva;
    }

    public LignedeCommandeProduit(Produit produit) {
        this();
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Collection<DemandeParticuliere> getDemandeParticulieres() {
        return demandeParticulieres;
    }

    public void setDemandeParticulieres(Collection<DemandeParticuliere> demandeParticulieres) {
        this.demandeParticulieres = demandeParticulieres;
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
        if (!(object instanceof LignedeCommandeProduit)) {
            return false;
        }
        LignedeCommandeProduit other = (LignedeCommandeProduit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produit: " + produit.getNom() + " quantite: " + quantite + " emplacement :" + commande.getEmplacement().getNumero();
    }

}
