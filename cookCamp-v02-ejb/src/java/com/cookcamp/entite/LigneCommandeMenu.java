package com.cookcamp.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LigneCommandeMenu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantite;
    private float prix;
    private float tva;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Menu menu;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Commande commande;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Produit> produits;

    @OneToOne(mappedBy = "ligneCommandeMenu")
    private Collection<DemandeParticuliere> demandeParticulieres;
//    private List<DemandeParticuliere> demandeParticulieres = new ArrayList<DemandeParticuliere>();
    

    public LigneCommandeMenu() {
        produits = new ArrayList<>();
        demandeParticulieres = new ArrayList<>();
        //commande=new Commande();
        //produit=new Produit();
    }

    public LigneCommandeMenu(int quantite, float prix, float tva) {
        this();
        this.quantite = quantite;
        this.prix = prix;
        this.tva = tva;
    }

    

    public LigneCommandeMenu(Menu menu) {
        this();
        this.menu = menu;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    
    public Collection<DemandeParticuliere> getDemandeParticulieres() {
        return demandeParticulieres;
    }

    public void setDemandeParticulieres(Collection<DemandeParticuliere> demandeParticulieres) {
        this.demandeParticulieres = demandeParticulieres;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final LigneCommandeMenu other = (LigneCommandeMenu) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
