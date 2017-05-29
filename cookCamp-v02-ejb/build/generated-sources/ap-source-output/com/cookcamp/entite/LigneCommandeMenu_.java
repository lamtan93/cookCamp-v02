package com.cookcamp.entite;

import com.cookcamp.entite.Commande;
import com.cookcamp.entite.DemandeParticuliere;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(LigneCommandeMenu.class)
public class LigneCommandeMenu_ { 

    public static volatile CollectionAttribute<LigneCommandeMenu, Produit> produits;
    public static volatile SingularAttribute<LigneCommandeMenu, Float> prix;
    public static volatile CollectionAttribute<LigneCommandeMenu, DemandeParticuliere> demandeParticulieres;
    public static volatile SingularAttribute<LigneCommandeMenu, Long> id;
    public static volatile SingularAttribute<LigneCommandeMenu, Menu> menu;
    public static volatile SingularAttribute<LigneCommandeMenu, Commande> commande;
    public static volatile SingularAttribute<LigneCommandeMenu, Float> tva;
    public static volatile SingularAttribute<LigneCommandeMenu, Integer> quantite;

}