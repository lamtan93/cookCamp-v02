package com.cookcamp.entite;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name="com.cookcamp.entite.Produit.findProduitByType", query="select p from Produit p where p.type.nom = :paramType"),
    })
public class Produit extends Choix implements Serializable {

    private static final long serialVersionUID = 1L;

    private String urlImage;
    @Column(nullable = false)
    private int stock;
    @Column(nullable = true)
    private String description;

    
    @ManyToMany (mappedBy = "produits")
    private Collection<Menu> menus;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Type type;
    
    @ManyToMany
    private Collection<Menu> produits;
    
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Collection <Information> informations;
    
     @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Collection <Ingredient> ingredients;
    
//    @ManyToMany(mappedBy = "produits");
//    private Collection<LigneCommandeMenu> lignesCommandeMenus;
    
    public Produit()
    {
        menus = new ArrayList<>();
        informations = new ArrayList<>();
        ingredients = new ArrayList<>();
//        lignesCommandeMenus = new ArrayList<>();
    }

    public Collection<Menu> getProduits() {
        return produits;
    }

//    public void setProduits(Collection<Menu> produits) {
//        this.produits = produits;
//    }
//
//    public Collection<LigneCommandeMenu> getCollecLigneCommandeMenus() {
////        return lignesCommandeMenus;
//    }
//
//    public void setCollecLigneCommandeMenus(Collection<LigneCommandeMenu> collecLigneCommandeMenus) {
////        this.lignesCommandeMenus = collecLigneCommandeMenus;
//    }
    

    public Produit(String urlImage, int stock, String description, String nom, float prix) {
              
        super(nom, prix);
        menus = new ArrayList<>();
        informations = new ArrayList<>();
        ingredients = new ArrayList<>();
//        LigneCommandeMenus = new ArrayList<>();
//        LigneCommandeProduits = new ArrayList<>();
        this.urlImage = urlImage;
        this.stock = stock;
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }

    public Collection<Menu> getMenu() {
        return menus;
    }

    public void setMenu(Collection<Menu> menu) {
        this.menus = menu;
    }

    

    public Collection<Information> getInformations() {
        return informations;
    }

    public void setInformations(Collection<Information> informations) {
        this.informations = informations;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

//    public Collection<LigneCommandeMenu> getLigneCommandeMenus() {
//        return LigneCommandeMenus;
//    }
//
//    public void setLigneCommandeMenus(Collection<LigneCommandeMenu> LigneCommandeMenus) {
//        this.LigneCommandeMenus = LigneCommandeMenus;
//    }
//
//    public Collection<LigneCommandeMenu> getLigneCommandeProduits() {
//        return LigneCommandeProduits;
//    }
//
//    public void setLigneCommandeProduits(Collection<LigneCommandeMenu> LigneCommandeProduits) {
//        this.LigneCommandeProduits = LigneCommandeProduits;
//    }

    
    
    
    
    
    @Override
    public String toString() {
        return super.toString() + "stock: " + this.stock + " " + " description :" + this.description;
    }

}
