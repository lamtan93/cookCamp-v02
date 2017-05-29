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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name="com.cookcamp.entite.Menu.findAllMenus", query="select m from Menu m")
})
public class Menu extends Choix implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String typeMoment;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Produit> produits;

    public Menu() {
        produits = new ArrayList<>();

    }

    public Menu(String typeMoment, String nom, float prix) {
        super(nom, prix);
        produits = new ArrayList<>();
        this.typeMoment = typeMoment;

    }

    public String getTypeMoment() {
        return typeMoment;
    }

    public void setTypeMoment(String typeMoment) {
        this.typeMoment = typeMoment;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return super.toString() + "typeMoment:  " + this.typeMoment;
    }

}
